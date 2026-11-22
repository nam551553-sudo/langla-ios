package com.beatdz.langlalau.handler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyDocumentListener implements DocumentListener {
   private JTextField a;
   private JLabel b;

   public MyDocumentListener(JTextField var1, JLabel var2) {
      this.a = var1;
      this.b = var2;
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
