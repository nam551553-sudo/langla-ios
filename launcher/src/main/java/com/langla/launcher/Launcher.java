package com.langla.launcher;
import com.badlogic.gdx.utils.JsonValue;import com.badlogic.gdx.utils.JsonReader;
import java.io.*;import java.net.*;import java.nio.file.*;import java.security.*;import java.util.*;
/** Same version.json/coreJarUrl/buildId protocol as Combo_Vip/client/PcLauncher.cs. */
public final class Launcher {
 public static final String BASE="http://103.77.172.222/langlaapp/langla-test/";
 public static InputStream open(URL url)throws IOException{URLConnection c=url.openConnection();c.setConnectTimeout(5000);c.setReadTimeout(15000);c.setUseCaches(false);return c.getInputStream();}
 public static String md5(Path file)throws Exception{MessageDigest d=MessageDigest.getInstance("MD5");try(InputStream in=Files.newInputStream(file)){byte[] b=new byte[65536];int n;while((n=in.read(b))!=-1)d.update(b,0,n);}StringBuilder out=new StringBuilder();for(byte b:d.digest())out.append(String.format("%02x",b&255));return out.toString();}
 public static void update(Path home,String manifestUrl)throws Exception{
  JsonValue pc;try(InputStream in=open(new URL(manifestUrl))){pc=new JsonReader().parse(in).get("pc");}if(pc==null)return;
  String hash=pc.getString("coreJarMd5"),id=pc.getString("buildId");if(!hash.matches("[a-fA-F0-9]{32}"))throw new IOException("Invalid core hash");
  Path game=home.resolve("game.jar"),marker=home.resolve("client-build-id.txt");
  if(Files.exists(game)&&hash.equalsIgnoreCase(md5(game))) {Files.write(marker,id.getBytes("UTF-8"));return;}
  Path temp=home.resolve("game.jar.downloading");
  try{try(InputStream in=open(new URL(new URL(manifestUrl),pc.getString("coreJarUrl")))){Files.copy(in,temp,StandardCopyOption.REPLACE_EXISTING);}
   if(Files.size(temp)!=pc.getLong("coreJarSize")||!hash.equalsIgnoreCase(md5(temp)))throw new IOException("Core size/hash mismatch");
   try(java.util.jar.JarFile jar=new java.util.jar.JarFile(temp.toFile())){if(jar.getEntry("com/beatdz/langlalau/DesktopLauncher.class")==null)throw new IOException("Not a game core");}
   if(Files.exists(game))Files.copy(game,home.resolve("game.jar.previous"),StandardCopyOption.REPLACE_EXISTING);
   Files.move(temp,game,StandardCopyOption.REPLACE_EXISTING);Files.write(marker,id.getBytes("UTF-8"));
  }finally{Files.deleteIfExists(temp);}
 }
 public static void main(String[] args){
  try { launch(args); }
  catch(Throwable error){
   try{Path log=Paths.get("launcher-error.log").toAbsolutePath();try(PrintWriter out=new PrintWriter(Files.newBufferedWriter(log))){error.printStackTrace(out);}javax.swing.JOptionPane.showMessageDialog(null,"Không mở được game: "+error.getMessage()+"\nChi tiết: "+log,"Làng Lá Test",javax.swing.JOptionPane.ERROR_MESSAGE);}catch(Throwable ignored){error.printStackTrace();}
  }
 }
 private static void launch(String[] args)throws Exception{
  Path home=Paths.get(".langla-test").toAbsolutePath();Files.createDirectories(home);Path game=home.resolve("game.jar");
  try(java.nio.channels.FileChannel channel=java.nio.channels.FileChannel.open(home.resolve("launch.lock"),StandardOpenOption.CREATE,StandardOpenOption.WRITE);java.nio.channels.FileLock lock=channel.lock()){
   if(!Files.exists(game))try(InputStream in=Launcher.class.getResourceAsStream("/bootstrap/game.jar")){if(in==null)throw new IOException("Missing bundled core");Files.copy(in,game);}
   String url=BASE+"version.json";Path override=Paths.get("update_url.txt");if(Files.isRegularFile(override))url=new String(Files.readAllBytes(override),"UTF-8").trim();
   try{update(home,url);}catch(Exception e){Files.write(home.resolve("update-error.log"),(e.toString()+"\n").getBytes("UTF-8"));}
  }
  List<String> command=new ArrayList<String>();String exe=System.getProperty("os.name").toLowerCase().contains("win")?"java.exe":"java";
  if(!Files.isRegularFile(Paths.get(System.getProperty("java.home"),"bin",exe)))throw new IOException("Thiếu runtime/bin/"+exe+". Cần dùng đủ bộ PC mới có runtime Java.");
  command.add(Paths.get(System.getProperty("java.home"),"bin",exe).toString());if(Boolean.getBoolean("langla.softwareRenderer"))command.add("-Dlangla.softwareRenderer=true");
  command.add("-cp");command.add(game.toString());command.add("com.beatdz.langlalau.DesktopLauncher");Collections.addAll(command,args);
  ProcessBuilder builder=new ProcessBuilder(command);builder.redirectErrorStream(true);builder.redirectOutput(ProcessBuilder.Redirect.appendTo(home.resolve("game.log").toFile()));System.exit(builder.start().waitFor());
 }
}
