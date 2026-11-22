package com.boot;

import beatdz.AppListener;
import beatdz.GameSrc;
import beatdz.*;
import beatdz.LangLa_dd;
import com.listener.AppEventListener;
import com.listener.IDialogTextListener;

public class GameM extends AppListener {
   public static AppListener l() {
      return AppListener.gI();
   }

   public static void b(AppEventListener var0) {
      AppListener.gI().setAppEventListener(var0);
   }

   public static void a(IDialogTextListener var0) {
      LangLa_dd.a = var0;
   }

   public static void m() {
      GameSrc.gI();
      GameSrc.k();
   }
}
