package beatdz;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

 class LangLa_dg implements DocumentListener {
   
   JTextField a;
   
   JLabel b;
   
   LangLa_de c;

   LangLa_dg(LangLa_de var1, JTextField var2, JLabel var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void removeUpdate(DocumentEvent var1) {
      this.a();
   }

   public void insertUpdate(DocumentEvent var1) {
      this.a();
   }

   public void changedUpdate(DocumentEvent var1) {
      this.a();
   }

   private void a() {
      if (this.a.getText().length() == 0) {
         this.b.setVisible(true);
      } else {
         this.b.setVisible(false);
      }
   }
}
