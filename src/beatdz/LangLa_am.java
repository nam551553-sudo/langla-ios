package beatdz;

import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Vector;

public class LangLa_am extends LangLa_kj {
   final EquipmentQuote.Query quote = new EquipmentQuote.Query();
   private final Item[] selection = new Item[21];
   private EquipmentQuote confirmedQuote;
   private long submittedAt;
   public Item[] a = new Item[1];
   public Item[] b = new Item[20];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int c;
   public LangLa_jw d;
   public Item e;

   public LangLa_am(MainScreen var1) {
      super(var1, new String[]{Caption.rx[7], Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 202, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[2] = new LangLa_ij((byte)0, 14, this.a_() + 20, 128, 160, 32, 5, 4);
      this.h = this.a(this.width - 70, this.height - 33, Caption.bi, this, 0, -8);
      this.a(this.h, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].r()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         try {
            refreshQuote();
         } catch (IOException error) {
            Utlis.println(error);
         }
         for (int var3 = 0; var3 < this.g.length; ++var3) {
            this.g[var3].a();
         }
      } else {
         this.a();
      }

      if (this.d != null) {
         this.d.p();
         if (this.d.r()) {
            this.d = null;
         }
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.nE, 14, this.a_() + 9, 0, -10831436, -16777216);
         drawQuote(var1);
         a(var1, this.g[0].cx, this.g[0].cy, this.e, this.g[0].k >= 0, Caption.I);
         this.a(var1, this.g[2]);

         for(int var2 = 0; var2 < this.g[2].i; ++var2) {
            for(int var3 = 0; var3 < this.g[2].r; ++var3) {
               b(var1, var3 * this.g[2].h, var2 * this.g[2].h, this.b[var2 * this.g[2].r + var3], var2 * this.g[2].i + var3 == this.g[2].k, "");
            }
         }

         this.b(var1);
         if (this.d != null) {
            this.d.b(var1, this.g[0].cx + this.g[0].h / 2, this.g[0].cy + this.g[0].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.g.length; ++var2) {
            if (var2 != 1) {
               var1.addElement(this.g[var2].a(1001 + var2, this));
            }
         }
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 0:
            this.a(true);
            return;
         case 1001:
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.nF, -1);
               return;
            }

            this.c = 1;
            this.a(var1.j, var1.j.k);
            showPreview();
            return;
         case 1003:
            int index = var1.j.k;
            if (index < 0 || index >= this.b.length) return;
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = b(var1, this, this.b[index]);
            return;
         case 2001:
            this.a(false);
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.g.length; ++var3) {
         this.g[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      quote.clear();
      confirmedQuote = null;

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            Char.gI().h(this.b[var1].TYPE_TEMP)[this.b[var1].index] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }

   boolean awaitingResult() {
      return System.currentTimeMillis() - submittedAt < 1500;
   }

   private int selectedCount() {
      int count = 0;
      for (Item item : b) if (item != null) count++;
      return count;
   }

   void refreshQuote() throws IOException {
      if (awaitingResult()) return;
      boolean primarySelected = false;
      for (Item item : b) {
         if (item != null && item == a[0]) {
            primarySelected = true;
            break;
         }
      }
      if (!primarySelected) {
         a[0] = null;
         for (Item item : b) {
            if (item != null) {
               a[0] = item;
               break;
            }
         }
      }
      selection[0] = a[0];
      System.arraycopy(b, 0, selection, 1, b.length);
      int count = selectedCount();
      if (!quote.refresh(selection, count >= 2, false)) return;
      e = null;
      if (count >= 2) {
         Message request = EquipmentQuote.request(EquipmentQuote.COSTUME_FUSION, quote.requestId);
         writeSelection(request, count);
         request.send();
      }
   }

   void acceptQuote(EquipmentQuote received) {
      quote.accept(received);
      e = received.result;
   }

   private void writeSelection(Message message, int count) throws IOException {
      message.writeByte(count);
      message.writeByte(a[0].TYPE_TEMP);
      message.writeShort(a[0].index);
      for (Item item : b) {
         if (item != null && item != a[0]) {
            message.writeByte(item.TYPE_TEMP);
            message.writeShort(item.index);
         }
      }
   }

   private void drawQuote(Graphics graphics) {
      EquipmentQuote cost = quote.value;
      int firstLine = a_() + 88;
      if (cost == null || !cost.valid) {
         if (selectedCount() >= 2) {
            Vector lines = mFont.a(mFont.d, quote.status(), width - 158);
            for (int i = 0; i < lines.size(); i++) {
               mFont.b(mFont.d, graphics, (String) lines.get(i), 149, firstLine + i * 12, 0, -2560, -16777216);
            }
         }
         return;
      }
      mFont.b(mFont.d, graphics, "Bạc: " + Utlis.numberFormat(cost.silver), 149, firstLine, 0, -30976, -16777216);
      mFont.b(mFont.d, graphics, "Bạc khóa: " + Utlis.numberFormat(cost.lockedSilver), 149, firstLine + 11, 0, -30976, -16777216);
      mFont.b(mFont.d, graphics, "Vàng: " + Utlis.numberFormat(cost.gold), 149, firstLine + 22, 0, -30976, -16777216);
      mFont.b(mFont.d, graphics, cost.materials.length + " món sẽ dùng", 149, firstLine + 33, 0, -30976, -16777216);
      mFont.b(mFont.d, graphics, cost.originalCount + " cải trang gốc", 149, firstLine + 44, 0, -30976, -16777216);
      mFont.b(mFont.d, graphics, "Chạm kết quả để xem", 149, firstLine + 55, 0, -10831436, -16777216);
   }

   private void a(boolean confirm) {
      try {
         if (awaitingResult()) return;
         int count = selectedCount();
         if (count < 2) {
            p.showMessage(Caption.nE, -65536);
            return;
         }
         refreshQuote();
         EquipmentQuote cost = quote.value;
         if (cost == null || !cost.valid || !cost.problem.isEmpty()) {
            p.showMessage(quote.status(), -65536);
            return;
         }
         if (confirm) {
            confirmedQuote = cost;
            p.a(cost.fees() + "\n" + Caption.nH, 2001, this);
            return;
         }
         if (confirmedQuote != cost) {
            p.showMessage("Danh sách cải trang đã thay đổi. Hãy chọn Ghép lại.", -65536);
            return;
         }
         Message request = new Message((byte) -50);
         writeSelection(request, count);
         request.writeInt(quote.requestId);
         request.send();
         confirmedQuote = null;
         quote.clear();
         submittedAt = System.currentTimeMillis();
      } catch (IOException error) {
         Utlis.println(error);
      }
   }

   public void a(Item item) {
      a[0] = item;
      e = null;
      quote.clear();
   }

   private void showPreview() {
      if (e == null || quote.value == null || !quote.value.valid) {
         p.showMessage(quote.status(), -65536);
         return;
      }
      String details = quote.value.details(e) + "\nCải trang sau khi ghép sẽ bị khóa.";
      p.a((LangLa_cx) new ReleaseNotesDialog(p, "Xem trước cải trang", details));
   }
}
