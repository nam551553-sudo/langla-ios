package beatdz;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/** Offline network/route tests; no game server, GL, account or cache is accessed. */
public final class MapPrefetchCheck {
    private static final byte[] PNG = {(byte)137,80,78,71,13,10,26,10};
    private static void check(boolean value, String message) { if (!value) throw new AssertionError(message); }
    private static final class Fake implements HttpDownloads.Transport {
        final AtomicInteger opens = new AtomicInteger(), active = new AtomicInteger(), peak = new AtomicInteger();
        final AtomicInteger failures = new AtomicInteger();
        volatile boolean bad;
        volatile int size = PNG.length;
        volatile int delay = 80;
        volatile CountDownLatch gate;
        volatile String gatedUrl;
        public HttpDownloads.Response open(String url, int timeout, long max, HttpDownloads.Progress progress) throws IOException {
            opens.incrementAndGet();
            int current = active.incrementAndGet(); peak.accumulateAndGet(current, Math::max);
            try {
                if (failures.getAndDecrement() > 0) throw new IOException("Simulated connection reset");
                if (gate != null && (gatedUrl == null || gatedUrl.equals(url))) {
                    if (!gate.await(5,TimeUnit.SECONDS)) throw new IOException("Test gate timeout");
                }
                else Thread.sleep(delay);
                byte[] data = bad ? "<html>error</html>".getBytes("UTF-8") : Arrays.copyOf(PNG, size);
                return new HttpDownloads.Response(new ByteArrayInputStream(data),data.length,true);
            } catch (InterruptedException e) { throw new IOException(e); }
            finally { active.decrementAndGet(); }
        }
    }
    public static void main(String[] args) throws Exception {
        short[][] links = {{1,0,0,20,50,2,600,0,620,50},{1,900,0,920,50,3,0,0,20,50},null,{1}, {1,0,0,0,0,-1,0,0,0,0}};
        check(MapAssetPrefetch.neighbours(1,links).equals(new LinkedHashSet<Integer>(Arrays.asList(2,3))),"Neighbours");
        check(MapAssetPrefetch.nearest(1,900,50,links)==3,"Nearest destination");
        check(MapAssetPrefetch.nearest(2,610,50,links)==1,"Reverse portal");
        check(MapAssetPrefetch.nearest(1,450,800,links)==-1,"Far portal");
        check(new ArrayList<Integer>(MapAssetPrefetch.order(1,3,links)).equals(Arrays.asList(3,1,2)),"Priority and deduplication");
        ByteArrayOutputStream data=new ByteArrayOutputStream(); DataOutputStream out=new DataOutputStream(data);
        out.writeShort(0);out.writeShort(1);out.writeInt(0);out.writeByte(1);out.writeShort(17);out.write(new byte[5]);out.writeByte(0);
        out.writeInt(0);out.writeByte(0);out.writeShort(0);out.writeShort(0);out.writeShort(1);out.writeShort(33);out.writeShort(1);out.write(new byte[5]);
        check(MapAssetPrefetch.treeIds(data.toByteArray()).equals(new LinkedHashSet<Short>(Arrays.asList((short)17,(short)33))),"Layout image IDs");
        try { MapAssetPrefetch.treeIds(new byte[]{0});throw new AssertionError("Accepted truncated layout"); } catch(IOException expected) {}
        ExecutorService pool=Executors.newFixedThreadPool(12);
        Fake fake=new Fake();HttpDownloads.install(fake);
        try {
            List<Future<byte[]>> jobs=new ArrayList<Future<byte[]>>();
            long started=System.nanoTime();
            for(int i=0;i<12;i++){final int n=i;jobs.add(pool.submit(()->MapAssetDownloads.load("test://image/"+n)));}
            for(Future<byte[]> job:jobs)check(Arrays.equals(job.get(5,TimeUnit.SECONDS),PNG),"Download data");
            check(fake.peak.get()>1 && fake.peak.get()<=4,"Concurrency budget");
            System.out.println("12 delayed image requests: "+TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-started)+"ms; peak active="+fake.peak.get()+" (limit 4; simulated 80ms/request).");
            fake.opens.set(0);fake.gate=new CountDownLatch(1);jobs.clear();
            CountDownLatch launched=new CountDownLatch(8);
            for(int i=0;i<8;i++)jobs.add(pool.submit(()->{launched.countDown();return MapAssetDownloads.load("test://shared");}));
            check(launched.await(2,TimeUnit.SECONDS),"Clients not launched");Thread.sleep(150);fake.gate.countDown();
            List<byte[]> results=new ArrayList<byte[]>();for(Future<byte[]> job:jobs)results.add(job.get(5,TimeUnit.SECONDS));
            check(fake.opens.get()==1,"Duplicate URL downloaded more than once");
            results.get(0)[0]=0;check(results.get(1)[0]==PNG[0],"Mutable decode buffer shared between callers");
            fake.opens.set(0);
            byte[] cached = MapAssetDownloads.load("test://shared");
            check(fake.opens.get()==0 && cached[0]==PNG[0],"A later account should reuse the completed request");
            cached[0]=0;
            check(MapAssetDownloads.load("test://shared")[0]==PNG[0],"Cached bytes must survive destructive image decoding");
            fake.gate = new CountDownLatch(1);
            fake.gatedUrl = "test://slow-shared-tree";
            FutureTask<byte[]> tree = MapAssetDownloads.request(fake.gatedUrl);
            for (int tab = 1; tab < 6; tab++) {
                check(MapAssetDownloads.request(fake.gatedUrl) == tree, "duplicate tab requests reuse one network task");
            }
            try {
                FutureTask<byte[]> npc = MapAssetDownloads.request("test://next-npc");
                FutureTask<byte[]> mob = MapAssetDownloads.request("test://next-mob");
                npc.get(2, TimeUnit.SECONDS);
                mob.get(2, TimeUnit.SECONDS);
                check(!tree.isDone(), "distinct NPC/quái images must finish while six tabs await the slow tree");
            } finally {
                fake.gate.countDown();
            }
            tree.get(5, TimeUnit.SECONDS);
            System.out.println("Six tabs waiting for one slow tree leave download slots free for NPC and mob images.");
            fake.gate=null;fake.bad=true;
            try{MapAssetDownloads.load("test://bad");throw new AssertionError("Accepted HTML");}catch(IOException expected){}
            fake.bad=false;check(Arrays.equals(MapAssetDownloads.load("test://bad"),PNG),"Failed request retained / permit leaked");
            fake.opens.set(0);fake.failures.set(1);
            check(Arrays.equals(MapAssetDownloads.load("test://transient"),PNG) && fake.opens.get()==2,"Transient failure not retried");
            fake.opens.set(0);
            MapAssetDownloads.load("test://version/1/image");
            MapAssetDownloads.load("test://version/2/image");
            check(fake.opens.get()==2,"A changed artwork version must fetch new bytes");
            fake.delay=0;fake.size=256*1024;
            for(int i=0;i<40;i++) MapAssetDownloads.load("test://evict/"+i);
            fake.opens.set(0);
            MapAssetDownloads.load("test://evict/39");
            check(fake.opens.get()==0,"The newest image stays in the shared cache");
            MapAssetDownloads.load("test://evict/0");
            check(fake.opens.get()==1,"The compressed cache must evict old images after its memory limit");
            System.out.println("PASS: portal ordering, reverse links, layout parsing, bounded parallelism, shared downloads across tabs, bounded versioned cache, isolated buffers, invalid-response rejection and recovery.");
        } finally {HttpDownloads.install(null);pool.shutdownNow();}
    }
}
