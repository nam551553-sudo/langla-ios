package com.beatdz.langlalau.handler;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class MyWindowsFocusListener implements WindowFocusListener {
   private JComponent a;

   public MyWindowsFocusListener(JTextField var1) {
      this.a = var1;
   }

   public void windowLostFocus(WindowEvent var1) {
   }

   public void windowGainedFocus(WindowEvent var1) {
      this.a.requestFocusInWindow();
   }
}
