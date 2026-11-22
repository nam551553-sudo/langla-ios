package beatdz;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JTextField;

 class LangLa_dh implements WindowFocusListener {
   
   JTextField a;
   
   LangLa_de b;

   LangLa_dh(LangLa_de var1, JTextField var2) {
      this.b = var1;
      this.a = var2;
   }

   public void windowLostFocus(WindowEvent var1) {
   }

   public void windowGainedFocus(WindowEvent var1) {
      this.a.requestFocusInWindow();
   }
}
