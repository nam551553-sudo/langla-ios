package beatdz;
import com.badlogic.gdx.Input.TextInputListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

 class LangLa_de implements Runnable {
   
   String a;
   
   String b;
   
   String c;
   
   TextInputListener d;

   LangLa_de(String var1, String var2, String var3, TextInputListener var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void run() {
      JPanel var1 = new JPanel(new FlowLayout());
      LangLa_df var2;
      (var2 = new LangLa_df(this)).setLayout(new OverlayLayout(var2));
      var1.add(var2);
      JTextField var3;
      (var3 = new JTextField(20)).setText(this.a);
      var3.setAlignmentX(0.0F);
      var2.add(var3);
      JLabel var4;
      (var4 = new JLabel(this.b)).setForeground(Color.GRAY);
      var4.setAlignmentX(0.0F);
      var2.add(var4, 0);
      var3.getDocument().addDocumentListener(new LangLa_dg(this, var3, var4));
      JOptionPane var5;
      (var5 = new JOptionPane(var1, 3, 2, (Icon)null, (Object[])null, (Object)null)).setInitialValue((Object)null);
      var5.setComponentOrientation(JOptionPane.getRootFrame().getComponentOrientation());
      Border var7 = var3.getBorder();
      var4.setBorder(new EmptyBorder(var7.getBorderInsets(var3)));
      LangLa_dd.b = var5.createDialog((Component)null, this.c);
      LangLa_dd.b.setAlwaysOnTop(true);
      var5.selectInitialValue();
      LangLa_dd.b.addWindowFocusListener(new LangLa_dh(this, var3));
      LangLa_dd.b.setVisible(true);
      LangLa_dd.b.dispose();
      Object var6;
      if ((var6 = var5.getValue()) != null && var6 instanceof Integer && (Integer)var6 == 0) {
         this.d.input(var3.getText());
      } else {
         this.d.canceled();
      }
   }
}
