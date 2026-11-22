package com.beatdz.langlalau.handler;

import com.badlogic.gdx.Input.TextInputListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InputDialogHandler implements Runnable {
   private String a;
   private JDialog b;
   private String c;
   private TextInputListener d;
   private String e;

   public InputDialogHandler(JDialog var1, TextInputListener var2, String var3, String var4, String var5) {
      this.a = var4;
      this.b = var1;
      this.c = var5;
      this.d = var2;
      this.e = var3;
   }

   public void run() {
      JPanel var1 = new JPanel(new FlowLayout());
      JPanel var2;
      (var2 = new JPanel()).setLayout(new OverlayLayout(var2));
      var1.add(var2);
      JTextField var3;
      (var3 = new JTextField(20)).setText(this.a);
      var3.setAlignmentX(0.0F);
      var2.add(var3);
      JLabel var4;
      (var4 = new JLabel(this.c)).setForeground(Color.GRAY);
      var4.setAlignmentX(0.0F);
      var2.add(var4, 0);
      var3.getDocument().addDocumentListener(new MyDocumentListener(var3, var4));
      JOptionPane var5;
      (var5 = new JOptionPane(var1, 3, 2, (Icon)null, (Object[])null, (Object)null)).setInitialValue((Object)null);
      var5.setComponentOrientation(JOptionPane.getRootFrame().getComponentOrientation());
      Border var7 = var3.getBorder();
      var4.setBorder(new EmptyBorder(var7.getBorderInsets(var3)));
      this.b = var5.createDialog((Component)null, this.e);
      this.b.setAlwaysOnTop(true);
      var5.selectInitialValue();
      this.b.addWindowFocusListener(new MyWindowsFocusListener(var3));
      this.b.setVisible(true);
      this.b.dispose();
      Object var6;
      if ((var6 = var5.getValue()) != null && var6 instanceof Integer && (Integer)var6 == 0) {
         this.d.input(var3.getText());
      } else {
         this.d.canceled();
      }
   }
}
