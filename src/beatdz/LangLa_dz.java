package beatdz;

import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_dz extends LangLa_cs {

    public String a;
    public int b;
    public int c = -1;
    public short d;
    public int e;
    public int f;
    public Object g;
    public boolean h;
    public byte i;
    protected long j = Long.MIN_VALUE;
    public LangLa_jw k;
    private long l;
    private boolean m;

    public LangLa_dz(int var1, int var2, int var3, int var4, String var5, LangLa_cx var6, int var7, int var8) {
        this.a = var5;
        this.s = var6;
        this.b = var7;
        this.f = 30;
        this.setXY(var1, var2);
        this.a(var8);
    }

    public void a(int var1) {
        this.d = (short) var1;
        switch (var1) {
            case -27:
            case 7:
            case 9:
                this.f = -10;
                this.setSize(74, 23);
                return;
            case -25:
            case 12:
            case 23:
            case 33:
            case 38:
            case 54:
            case 57:
            case 58:
            case 244:
            case 942:
                this.setSize(16, 16);
                return;
            case -24:
                this.setSize(70, 23);
                return;
            case -23:
            case -22:
            case -21:
            case -20:
            case -19:
            case -18:
                this.setSize(20, 20);
                return;
            case -17:
                this.setSize(68, 18);
                return;
            case -16:
            case 722:
            case 728:
            case 734:
                this.setSize(16, 14);
                return;
            case -15:
            case -14:
            case -13:
            case -12:
            case 554:
                if (mConfig.gI().readBoolean(15)) {
                    this.setSize(33, 33);
                    return;
                }

                this.setSize(25, 25);
                return;
            case -11:
            case 59:
                this.setSize(22, 30);
                return;
            case -10:
                this.setSize(102, 20);
                return;
            case -9:
            case -6:
            case -5:
            case -4:
            case -3:
                this.setSize(44, 20);
                return;
            case -8:
                this.f = -10;
                this.setSize(60, 23);
                return;
            case -7:
                this.setSize(50, 20);
                return;
            case -2:
                this.setSize(20, 20);
                return;
            case 6:
                this.setSize(22, 22);
                return;
            case 13:
                this.setSize(100, 24);
                return;
            case 14:
            case 36:
            case 49:
            case 67:
            case 75:
            case 76:
            case 77:
            case 78:
            case 81:
            case 84:
            case 85:
            case 455:
            case 522:
            case 647:
            case 659:
            case 648:
            case 660:
            case 687:
            case 1023:
            case 1024:
            case 1171:
            case 1172:
            case 1025:
            case 1026:
                this.setSize(20, 20);
                return;
            case 15:
                this.setSize(70, 22);
                return;
            case 16:
                this.f = 40;
                this.setSize(28, 28);
                return;
            case 17:
                this.f = 40;
                if (!mConfig.gI().readBoolean(15)) {
                    this.setSize(44, 44);
                    return;
                }
            case 709:
                this.setSize(60, 60);
            default:
                return;
            case 18:
                this.setSize(30, 30);
                return;
            case 19:
                this.setSize(30, 30);
                return;
            case 20:
                if (mConfig.gI().readBoolean(15)) {
                    this.setSize(80, 80);
                    return;
                }

                this.setSize(60, 60);
                return;
            case 21:
                this.setSize(74, 15);
                return;
            case 25:
                this.setSize(28, 20);
                return;
            case 39:
            case 245:
            case 715:
            case 1027:
                this.setSize(14, 14);
                return;
            case 42:
            case 61:
                this.setSize(30, 30);
                return;
            case 43:
            case 66:
            case 74:
            case 86:
                this.setSize(18, 18);
                return;
            case 52:
                this.setSize(14, 14);
                return;
            case 65:
                this.setSize(18, 18);
                return;
            case 73:
                this.setSize(20, 17);
                return;
            case 79:
                this.setSize(73, 83);
                return;
            case 82:
                this.setSize(20, 20);
                return;
            case 286:
            case 287:
                this.setSize(15, 12);
                return;
            case 288:
                this.setSize(15, 14);
                return;
            case 373:
                this.setSize(50, 16);
                return;
            case 374:
                this.setSize(16, 16);
                return;
            case 382:
                this.setSize(16, 16);
                return;
            case 398:
                this.setSize(18, 16);
                return;
            case 457:
                this.setSize(52, 18);
                return;
            case 460:
            case 620:
                this.setSize(25, 25);
                return;
            case 672:
                this.setSize(67, 32);
                return;
            case 716:
                this.setSize(30, 30);
        }
    }

    public void b() {
        if (this.b == 1020 && this.a() && this.s instanceof GameSrc && !SettingsTab.gI().autoTrain) {
            if (this.j == Long.MIN_VALUE) {
                this.j = Utlis.time();
            } else if (Utlis.time() - this.j >= 500L) {
                beatdz.SettingsTab.$state_SettingsTab().i = true;
                SettingsTab.gI().a(true);
                GameSrc.gI().aA = null;
            }
        }

        if (this.k != null) {
            this.k.p();
            if (this.k.r()) {
                this.k = null;
            }
        }

    }

    public void s() {
        super.s();
        this.j = Long.MIN_VALUE;
    }

    public void p() {
        if (!this.u && !this.v) {
            if (this.a()) {
                if (this.d != 57 && this.d != 58 && this.d != 49 && this.d != 244) {
                    if (this.d == 942) {
                        try {
                            if (this.l == 0L) {
                                LangLa_dt.b();
                                if (!LangLa_dt.a()) {
                                    this.l = Utlis.time();
                                    GameSrc.gI().l(Caption.pZ);
                                    return;
                                }

                                GameSrc.gI().ck = this.l = Utlis.time();
                                if (beatdz.LangLa_dt.$state_LangLa_dt().c.length() > 0 && Utlis.time() - beatdz.LangLa_dt.$state_LangLa_dt().b < 30000L) {
                                    LangLa_dt.a(false);
                                    return;
                                }

                                beatdz.LangLa_dt.$state_LangLa_dt().c = "";
                                Message var5;
                                (var5 = Message.c((byte) -34)).writeBoolean(false);
                                var5.send();
                            } else if (GameSrc.gI().ck > 0L) {
                                long var1;
                                if ((var1 = Utlis.time() - GameSrc.gI().ck) <= 10000L && GameSrc.gI().cE instanceof LangLa_ko) {
                                    if (var1 > 1000L && LangLa_dt.b().d) {
                                        GameSrc.gI().showMessage(Caption.qa, -3407617);
                                    }
                                } else {
                                    LangLa_dt.b().c();
                                }
                            }
                        } catch (Exception var4) {
                        }
                    }
                } else if (this.l == 0L) {
                    this.l = Utlis.time();
                } else if (!this.m) {
                    if (Utlis.time() - this.l > 400L) {
                        this.m = true;
                    }
                } else if (Utlis.time() - this.l > 60L) {
                    this.l = Utlis.time();
                    this.s.b(this.b, this.g, this);
                }

                this.s.b(this.b, this.g);
            } else {
                if (GameSrc.gI().ck > 0L && this.d == 942) {
                    LangLa_dt.b().c();
                }

                this.l = 0L;
                this.m = false;
            }

            if (this.cO.a[5]) {
                this.s.b(this.b, this.g, this);
            }

        }
    }

    public void a(Graphics var1) {
        int var2 = 0;
        int var3 = 0;
        boolean var11 = false;

        label2862:
        {
            label2863:
            {
                label2864:
                {
                    label2865:
                    {
                        label2866:
                        {
                            label2867:
                            {
                                label2868:
                                {
                                    label2914:
                                    {
                                        label2870:
                                        {
                                            label2915:
                                            {
                                                label2872:
                                                {
                                                    label2873:
                                                    {
                                                        label2874:
                                                        {
                                                            label2875:
                                                            {
                                                                label2876:
                                                                {
                                                                    label2877:
                                                                    {
                                                                        label2878:
                                                                        {
                                                                            label2879:
                                                                            {
                                                                                label2880:
                                                                                {
                                                                                    label2881:
                                                                                    {
                                                                                        label2882:
                                                                                        {
                                                                                            label2883:
                                                                                            {
                                                                                                label2884:
                                                                                                {
                                                                                                    label2885:
                                                                                                    {
                                                                                                        label2886:
                                                                                                        {
                                                                                                            label2887:
                                                                                                            {
                                                                                                                label2888:
                                                                                                                {
                                                                                                                    try {
                                                                                                                        var11 = true;
                                                                                                                        if (this.v) {
                                                                                                                            var11 = false;
                                                                                                                            break label2915;
                                                                                                                        }

                                                                                                                        if (this.i == 1) {
                                                                                                                            var2 = var1.a;
                                                                                                                            var3 = var1.b;
                                                                                                                            this.a(var1, -5000, -5000);
                                                                                                                        }

                                                                                                                        short var4 = this.d;
                                                                                                                        if (LangLa_fq.a((int) 7) == null) {
                                                                                                                            var1.f(7682054);
                                                                                                                            var1.c(0, 0, this.width, this.height);
                                                                                                                            Utlis.a((Graphics) var1, this.width, this.height);
                                                                                                                        }

                                                                                                                        if (this.a()) {
                                                                                                                            var1.e(30);
                                                                                                                        }

                                                                                                                        label2826:
                                                                                                                        {
                                                                                                                            label2825:
                                                                                                                            {
                                                                                                                                label2824:
                                                                                                                                {
                                                                                                                                    label2823:
                                                                                                                                    {
                                                                                                                                        label2822:
                                                                                                                                        {
                                                                                                                                            label2821:
                                                                                                                                            {
                                                                                                                                                label2820:
                                                                                                                                                {
                                                                                                                                                    label2819:
                                                                                                                                                    {
                                                                                                                                                        label2818:
                                                                                                                                                        {
                                                                                                                                                            label2817:
                                                                                                                                                            {
                                                                                                                                                                label2816:
                                                                                                                                                                {
                                                                                                                                                                    label2815:
                                                                                                                                                                    {
                                                                                                                                                                        label2814:
                                                                                                                                                                        {
                                                                                                                                                                            label2813:
                                                                                                                                                                            {
                                                                                                                                                                                label2812:
                                                                                                                                                                                {
                                                                                                                                                                                    label2811:
                                                                                                                                                                                    {
                                                                                                                                                                                        label2810:
                                                                                                                                                                                        {
                                                                                                                                                                                            label2809:
                                                                                                                                                                                            {
                                                                                                                                                                                                label2808:
                                                                                                                                                                                                {
                                                                                                                                                                                                    label2807:
                                                                                                                                                                                                    {
                                                                                                                                                                                                        label2806:
                                                                                                                                                                                                        {
                                                                                                                                                                                                            label2805:
                                                                                                                                                                                                            {
                                                                                                                                                                                                                label2804:
                                                                                                                                                                                                                {
                                                                                                                                                                                                                    label2803:
                                                                                                                                                                                                                    {
                                                                                                                                                                                                                        label2802:
                                                                                                                                                                                                                        {
                                                                                                                                                                                                                            label2801:
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    label2910:
                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                        int var20;
                                                                                                                                                                                                                                        if (var4 == 460 || var4 >= 329 && var4 <= 359) {
                                                                                                                                                                                                                                            if (this.a()) {
                                                                                                                                                                                                                                                LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            int var6;
                                                                                                                                                                                                                                            label2775:
                                                                                                                                                                                                                                            switch (this.d) {
                                                                                                                                                                                                                                                case 2907:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    mFont.b(mFont.f, var1, this.a, this.width / 2, this.height / 2, 2, -2560, 11184811);
                                                                                                                                                                                                                                                    break label2802;
                                                                                                                                                                                                                                                case -27:
                                                                                                                                                                                                                                                    if (this.u) {
                                                                                                                                                                                                                                                        Binary2.a(var1, 370, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, this.a, this.width / 2, this.height / 2, 2, -3089954, 0);
                                                                                                                                                                                                                                                        break label2802;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    Binary2.a(var1, 7, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    mFont.b(mFont.b, var1, this.a, this.width / 2, this.height / 2, 2, -1, 0);
                                                                                                                                                                                                                                                    break label2804;
                                                                                                                                                                                                                                                case -25:
                                                                                                                                                                                                                                                    var1.f(GameSrc.gI().ci);
                                                                                                                                                                                                                                                    var1.c(0, 0, 16, 16);
                                                                                                                                                                                                                                                    var1.f(GameSrc.gI().ci == -11184811 ? -1 : -11184811);
                                                                                                                                                                                                                                                    var1.b(0, 0, 16, 16);
                                                                                                                                                                                                                                                    var1.c();
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -24:
                                                                                                                                                                                                                                                    var1.f(-8966635);
                                                                                                                                                                                                                                                    var1.c(6, 2, this.width - 12, this.height - 4);
                                                                                                                                                                                                                                                    var1.f(-14939131);
                                                                                                                                                                                                                                                    var1.c(7, 3, this.width - 14, this.height - 6);
                                                                                                                                                                                                                                                    if (this.u) {
                                                                                                                                                                                                                                                        Binary2.a(var1, 370, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                        mFont.a(var1, this.a, this.width / 2, this.height / 2, 2, -11184811);
                                                                                                                                                                                                                                                        break label2816;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    Binary2.a(var1, 7, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    mFont.a(var1, this.a, this.width / 2, this.height / 2, 2, -1);
                                                                                                                                                                                                                                                    break label2814;
                                                                                                                                                                                                                                                case -23:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -1, -16777216);
                                                                                                                                                                                                                                                    break label2910;
                                                                                                                                                                                                                                                case -22:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 98, 270, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                    break label2809;
                                                                                                                                                                                                                                                case -21:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 98, 90, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                    break label2824;
                                                                                                                                                                                                                                                case -20:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 98, 180, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                    break label2826;
                                                                                                                                                                                                                                                case -19:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 98, 0, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                    break label2821;
                                                                                                                                                                                                                                                case -18:
                                                                                                                                                                                                                                                    Binary2.a(var1, -10, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -17:
                                                                                                                                                                                                                                                    var1.d();
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        var1.f(-1);
                                                                                                                                                                                                                                                        var1.a(0, 16, this.width, 1);
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2 + 1, this.height / 2 + 1, 2, -1, -15191233);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        var1.f(-1);
                                                                                                                                                                                                                                                        var1.a(0, 15, this.width, 1);
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -1, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2815;
                                                                                                                                                                                                                                                case -16:
                                                                                                                                                                                                                                                    switch (Char.gI().typePK) {
                                                                                                                                                                                                                                                        case 0:
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, 734, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                        case 1:
                                                                                                                                                                                                                                                        default:
                                                                                                                                                                                                                                                            break label2775;
                                                                                                                                                                                                                                                        case 2:
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, 722, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                            break label2775;
                                                                                                                                                                                                                                                        case 3:
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, 728, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                            break label2775;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                case -15:
                                                                                                                                                                                                                                                    if (!GameSrc.gI().bb) {
                                                                                                                                                                                                                                                        if (SettingsTab.gI().autoTrain) {
                                                                                                                                                                                                                                                            Binary2.b(var1, 711, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            Binary2.b(var1, 712, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        if (this.a()) {
                                                                                                                                                                                                                                                            Binary2.b(var1, 554, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -14:
                                                                                                                                                                                                                                                    if (!GameSrc.gI().bb) {
                                                                                                                                                                                                                                                        if (this.a()) {
                                                                                                                                                                                                                                                            Binary2.b(var1, 554, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        GameSrc.gI();
                                                                                                                                                                                                                                                        if ((var6 = GameSrc.x()) == -1) {
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, 236, this.e, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, var6, this.e, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, "" + GameSrc.gI().bw, this.width / 2, this.height / 2 + 7, 2, -1, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -13:
                                                                                                                                                                                                                                                    if (!GameSrc.gI().bb) {
                                                                                                                                                                                                                                                        if (this.a()) {
                                                                                                                                                                                                                                                            Binary2.b(var1, 554, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        GameSrc.gI();
                                                                                                                                                                                                                                                        if ((var6 = GameSrc.w()) == -1) {
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, 409, this.e, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            LangLa_fq.a(var1, var6, this.e, this.width / 2, this.height / 2, 3);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, "" + GameSrc.gI().bu, this.width / 2, this.height / 2 + 7, 2, -1, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -12:
                                                                                                                                                                                                                                                    if (!GameSrc.gI().bb && this.a()) {
                                                                                                                                                                                                                                                        Binary2.b(var1, 554, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -11:
                                                                                                                                                                                                                                                    var4 = 59;
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 59, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (GameSrc.gI().at) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 713, 0, 3, this.height / 2 - 4, 3);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -10:
                                                                                                                                                                                                                                                    LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
                                                                                                                                                                                                                                                    mFont.b(mFont.d, var1, this.a, 7, this.height / 2, 0, -1, -16777216);
                                                                                                                                                                                                                                                    break label2811;
                                                                                                                                                                                                                                                case -9:
                                                                                                                                                                                                                                                case -6:
                                                                                                                                                                                                                                                case -5:
                                                                                                                                                                                                                                                case -4:
                                                                                                                                                                                                                                                case -3:
                                                                                                                                                                                                                                                    if (this.u) {
                                                                                                                                                                                                                                                        Binary2.a(var1, 370, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, Caption.nh, this.width / 2, this.height / 2, 2, -3089954, 0);
                                                                                                                                                                                                                                                        break label2805;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    var4 = 7;
                                                                                                                                                                                                                                                    Binary2.a(var1, 7, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    var1.d();
                                                                                                                                                                                                                                                    byte var21 = 0;
                                                                                                                                                                                                                                                    var6 = this.width / 2 - 13;
                                                                                                                                                                                                                                                    if (this.d == -3) {
                                                                                                                                                                                                                                                        var21 = 2;
                                                                                                                                                                                                                                                    } else if (this.d == -4) {
                                                                                                                                                                                                                                                        var21 = 3;
                                                                                                                                                                                                                                                    } else if (this.d == -5) {
                                                                                                                                                                                                                                                        var21 = 0;
                                                                                                                                                                                                                                                    } else if (this.d == -6) {
                                                                                                                                                                                                                                                        var21 = 1;
                                                                                                                                                                                                                                                    } else if (this.d == -9) {
                                                                                                                                                                                                                                                        var21 = 4;
                                                                                                                                                                                                                                                        var6 += 3;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (var21 != 0 && var21 != 1) {
                                                                                                                                                                                                                                                        if (this.a()) {
                                                                                                                                                                                                                                                            a(var1, var6 + 1, this.height / 2 + 1, "", var21);
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            a(var1, var6, this.height / 2, "", var21);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } else if (this.a()) {
                                                                                                                                                                                                                                                        a(var1, var6 + 1, this.height / 2, "", var21);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        a(var1, var6, this.height / 2 - 1, "", var21);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -8:
                                                                                                                                                                                                                                                case 7:
                                                                                                                                                                                                                                                case 15:
                                                                                                                                                                                                                                                    var4 = 7;
                                                                                                                                                                                                                                                    if (this.u) {
                                                                                                                                                                                                                                                        Binary2.a(var1, 370, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -3089954, 0);
                                                                                                                                                                                                                                                        break label2808;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    Binary2.a(var1, 7, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case -7:
                                                                                                                                                                                                                                                    Binary2.a(var1, 15, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    var1.d();
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2 + 1, this.height / 2 + 1, 2, -6908266, -15191233);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -6908266, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2807;
                                                                                                                                                                                                                                                case -2:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2 + 1, this.height / 2 + 1, 2, -2560, -15191233);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -2560, -16777216);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        var1.d();
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    var1.f(-2560);
                                                                                                                                                                                                                                                    var1.a(0, 15, this.width, 1);
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        var1.e(30);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2803;
                                                                                                                                                                                                                                                case 9:
                                                                                                                                                                                                                                                    if (!this.u) {
                                                                                                                                                                                                                                                        break label2818;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    Binary2.a(var1, 370, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    var20 = (this.width - mFont.b(mFont.d, this.a)) / 2 - 9;
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 9, 0, var20, this.height / 2, 6);
                                                                                                                                                                                                                                                    mFont.b(mFont.d, var1, this.a, var20 + 16, this.height / 2, 0, -3089954, 0);
                                                                                                                                                                                                                                                    break label2801;
                                                                                                                                                                                                                                                case 13:
                                                                                                                                                                                                                                                    Binary2.a(var1, var4, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        mFont.b(mFont.f, var1, this.a, this.width / 2 + 1, this.height / 2, 2, -1, -16742145);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.f, var1, this.a, this.width / 2, this.height / 2 - 1, 2, -1, -16742145);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2820;
                                                                                                                                                                                                                                                case 14:
                                                                                                                                                                                                                                                case 73:
                                                                                                                                                                                                                                                case 78:
                                                                                                                                                                                                                                                case 522:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 17:
                                                                                                                                                                                                                                                    if (!GameSrc.gI().bb && this.a()) {
                                                                                                                                                                                                                                                        Binary2.b(var1, var4, this.e, 0, 0, this.width, this.height);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 25:
                                                                                                                                                                                                                                                    var4 = 7;
                                                                                                                                                                                                                                                    Binary2.a(var1, 7, this.e, 1, 1, this.width - 2, (int) (this.height - 2));
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, 7, this.e, 14, 10, 3);
                                                                                                                                                                                                                                                    var1.d();
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 33:
                                                                                                                                                                                                                                                case 38:
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 36:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (GameSrc.gI().am) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 713, 0, this.width - 5, 0, 0);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 42:
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        mFont.b(mFont.f, var1, this.a, this.width / 2, this.height / 2, 2, -1, -65536);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.e, var1, this.a, this.width / 2, this.height / 2, 2, -1, -65536);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2822;
                                                                                                                                                                                                                                                case 49:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (GameSrc.gI().as) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 713, 0, this.width - 5, 0, 0);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 79:
                                                                                                                                                                                                                                                    String[] var5 = this.a.split(" ");
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        Binary2.a(var1, 79, 0, -2, -2, 105);
                                                                                                                                                                                                                                                        mFont.b(mFont.g, var1, var5[0], this.width / 2 + 1, this.height / 2 + 1 - 3, 2, -1, -16742145);
                                                                                                                                                                                                                                                        mFont.b(mFont.g, var1, var5[1], this.width / 2 + 1, this.height / 2 + 1 + 10, 2, -1, -16742145);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                        mFont.b(mFont.g, var1, var5[0], this.width / 2, this.height / 2 - 3, 2, -1, 0);
                                                                                                                                                                                                                                                        mFont.b(mFont.g, var1, var5[1], this.width / 2, this.height / 2 + 10, 2, -1, 0);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2813;
                                                                                                                                                                                                                                                case 81:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    GameSrc.gI();
                                                                                                                                                                                                                                                    if (GameSrc.v() > 0) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 713, 0, this.width - 5, 0, 0);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 82:
                                                                                                                                                                                                                                                case 647:
                                                                                                                                                                                                                                                case 648:
                                                                                                                                                                                                                                                case 1023:
                                                                                                                                                                                                                                                case 1024:
                                                                                                                                                                                                                                                case 1025:
                                                                                                                                                                                                                                                case 1026:

                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 1171:
                                                                                                                                                                                                                                                case 1172:
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 286:
                                                                                                                                                                                                                                                case 287:
                                                                                                                                                                                                                                                case 288:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 1, 1, 20);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 373:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, this.a, this.width / 2 + 1, this.height / 2 + 1, 2, -3476028, -16777216);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, this.a, this.width / 2, this.height / 2, 2, -3476028, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2817;
                                                                                                                                                                                                                                                case 374:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2810;
                                                                                                                                                                                                                                                case 398:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, -1, 1, 20);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2819;
                                                                                                                                                                                                                                                case 554:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        Binary2.a(var1, var4, this.e, 0, 0, this.width, (int) this.height);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    int var10003;
                                                                                                                                                                                                                                                    if (Char.gI().w() && GameSrc.gI().bE) {
                                                                                                                                                                                                                                                        var10003 = this.width / 2;
                                                                                                                                                                                                                                                        int var10004 = this.height / 2;
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, DataCenter.gI().ItemTemplate[601].idIcon, this.e, var10003, var10004, 3);
                                                                                                                                                                                                                                                    } else if (GameSrc.gI().bz >= 0 && GameSrc.gI().bz < DataCenter.gI().ItemTemplate.length) {
                                                                                                                                                                                                                                                        var10003 = this.width / 2;
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, DataCenter.gI().ItemTemplate[GameSrc.gI().bz].idIcon, this.e, var10003, this.height / 2, 3);
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, "" + GameSrc.gI().by, this.width / 2, this.height / 2 + 7, 2, -1, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 660:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;

                                                                                                                                                                                                                                                case 687:
                                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (LangLa_cd.e() != null && GameSrc.gI().bO) {
                                                                                                                                                                                                                                                        LangLa_fq.a(var1, 713, 0, this.width - 5, 0, 0);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 716:
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4 + DataCenter.gI().i / 3 % 6, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                case 722:
                                                                                                                                                                                                                                                case 728:
                                                                                                                                                                                                                                                case 734:
                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    if (this.h) {
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, this.a, this.width / 2 - 5, this.height, 2, -1, -16777216);
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        mFont.b(mFont.b, var1, this.a, this.width / 2 - 5, this.height - 1, 2, -1, -16777216);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    break label2806;
                                                                                                                                                                                                                                                default:
                                                                                                                                                                                                                                                    if (this.c == 0) {
                                                                                                                                                                                                                                                        break label2812;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    if (this.c > 0) {
                                                                                                                                                                                                                                                        var1.d(this.c);
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                    LangLa_fq.a(var1, var4, this.e, 0, 0, 20);
                                                                                                                                                                                                                                                    if (this.c > 0) {
                                                                                                                                                                                                                                                        var1.m = 1.0F;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                        if (this.u) {
                                                                                                                                                                                                                                            mFont.b(mFont.d, var1, this.a, this.width / 2, this.height / 2, 2, -11184811, 0);
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            var20 = -1;
                                                                                                                                                                                                                                            if (var4 == 457) {
                                                                                                                                                                                                                                                var20 = -2565413;
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                            if (this.a()) {
                                                                                                                                                                                                                                                mFont.a(var1, this.a, this.width / 2 + 1, this.height / 2 + 1, 2, var20);
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                mFont.a(var1, this.a, this.width / 2, this.height / 2, 2, var20);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        break label2823;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } catch (Exception var16) {
                                                                                                                                                                                                                                    Utlis.println(var16);
                                                                                                                                                                                                                                    break label2825;
                                                                                                                                                                                                                                } finally {
                                                                                                                                                                                                                                    if (this.k != null) {
                                                                                                                                                                                                                                        this.k.b(var1, this.width / 2, this.height / 2);
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                    if (this.a()) {
                                                                                                                                                                                                                                        var1.d();
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                var11 = false;
                                                                                                                                                                                                                                break label2864;
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                            var11 = false;
                                                                                                                                                                                                                            break label2880;
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                        var11 = false;
                                                                                                                                                                                                                        break label2867;
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                    var11 = false;
                                                                                                                                                                                                                    break label2882;
                                                                                                                                                                                                                }

                                                                                                                                                                                                                var11 = false;
                                                                                                                                                                                                                break label2868;
                                                                                                                                                                                                            }

                                                                                                                                                                                                            var11 = false;
                                                                                                                                                                                                            break label2885;
                                                                                                                                                                                                        }

                                                                                                                                                                                                        var11 = false;
                                                                                                                                                                                                        break label2873;
                                                                                                                                                                                                    }

                                                                                                                                                                                                    var11 = false;
                                                                                                                                                                                                    break label2883;
                                                                                                                                                                                                }

                                                                                                                                                                                                var11 = false;
                                                                                                                                                                                                break label2884;
                                                                                                                                                                                            }

                                                                                                                                                                                            var11 = false;
                                                                                                                                                                                            break label2863;
                                                                                                                                                                                        }

                                                                                                                                                                                        var11 = false;
                                                                                                                                                                                        break label2875;
                                                                                                                                                                                    }

                                                                                                                                                                                    var11 = false;
                                                                                                                                                                                    break label2886;
                                                                                                                                                                                }

                                                                                                                                                                                var11 = false;
                                                                                                                                                                                break label2914;
                                                                                                                                                                            }

                                                                                                                                                                            var11 = false;
                                                                                                                                                                            break label2877;
                                                                                                                                                                        }

                                                                                                                                                                        var11 = false;
                                                                                                                                                                        break label2866;
                                                                                                                                                                    }

                                                                                                                                                                    var11 = false;
                                                                                                                                                                    break label2887;
                                                                                                                                                                }

                                                                                                                                                                var11 = false;
                                                                                                                                                                break label2865;
                                                                                                                                                            }

                                                                                                                                                            var11 = false;
                                                                                                                                                            break label2876;
                                                                                                                                                        }

                                                                                                                                                        var11 = false;
                                                                                                                                                        break label2881;
                                                                                                                                                    }

                                                                                                                                                    var11 = false;
                                                                                                                                                    break label2874;
                                                                                                                                                }

                                                                                                                                                var11 = false;
                                                                                                                                                break label2879;
                                                                                                                                            }

                                                                                                                                            var11 = false;
                                                                                                                                            break label2888;
                                                                                                                                        }

                                                                                                                                        var11 = false;
                                                                                                                                        break label2878;
                                                                                                                                    }

                                                                                                                                    var11 = false;
                                                                                                                                    break label2870;
                                                                                                                                }

                                                                                                                                var11 = false;
                                                                                                                                break label2862;
                                                                                                                            }

                                                                                                                            var11 = false;
                                                                                                                            break label2870;
                                                                                                                        }

                                                                                                                        var11 = false;
                                                                                                                    } catch (Exception var18) {
                                                                                                                        Utlis.println(var18);
                                                                                                                        var11 = false;
                                                                                                                        break label2872;
                                                                                                                    } finally {
                                                                                                                        if (var11) {
                                                                                                                            if (this.i == 0) {
                                                                                                                                this.i = 1;
                                                                                                                                this.a(var1);
                                                                                                                            } else if (this.i == 1) {
                                                                                                                                this.i = 2;
                                                                                                                                this.a(var1, var2, var3);
                                                                                                                            }

                                                                                                                        }
                                                                                                                    }

                                                                                                                    if (this.i == 0) {
                                                                                                                        this.i = 1;
                                                                                                                        this.a(var1);
                                                                                                                        return;
                                                                                                                    }

                                                                                                                    if (this.i == 1) {
                                                                                                                        this.i = 2;
                                                                                                                        this.a(var1, var2, var3);
                                                                                                                    }

                                                                                                                    return;
                                                                                                                }

                                                                                                                if (this.i == 0) {
                                                                                                                    this.i = 1;
                                                                                                                    this.a(var1);
                                                                                                                    return;
                                                                                                                }

                                                                                                                if (this.i == 1) {
                                                                                                                    this.i = 2;
                                                                                                                    this.a(var1, var2, var3);
                                                                                                                }

                                                                                                                return;
                                                                                                            }

                                                                                                            if (this.i == 0) {
                                                                                                                this.i = 1;
                                                                                                                this.a(var1);
                                                                                                                return;
                                                                                                            }

                                                                                                            if (this.i == 1) {
                                                                                                                this.i = 2;
                                                                                                                this.a(var1, var2, var3);
                                                                                                            }

                                                                                                            return;
                                                                                                        }

                                                                                                        if (this.i == 0) {
                                                                                                            this.i = 1;
                                                                                                            this.a(var1);
                                                                                                            return;
                                                                                                        }

                                                                                                        if (this.i == 1) {
                                                                                                            this.i = 2;
                                                                                                            this.a(var1, var2, var3);
                                                                                                        }

                                                                                                        return;
                                                                                                    }

                                                                                                    if (this.i == 0) {
                                                                                                        this.i = 1;
                                                                                                        this.a(var1);
                                                                                                        return;
                                                                                                    }

                                                                                                    if (this.i == 1) {
                                                                                                        this.i = 2;
                                                                                                        this.a(var1, var2, var3);
                                                                                                    }

                                                                                                    return;
                                                                                                }

                                                                                                if (this.i == 0) {
                                                                                                    this.i = 1;
                                                                                                    this.a(var1);
                                                                                                    return;
                                                                                                }

                                                                                                if (this.i == 1) {
                                                                                                    this.i = 2;
                                                                                                    this.a(var1, var2, var3);
                                                                                                }

                                                                                                return;
                                                                                            }

                                                                                            if (this.i == 0) {
                                                                                                this.i = 1;
                                                                                                this.a(var1);
                                                                                                return;
                                                                                            }

                                                                                            if (this.i == 1) {
                                                                                                this.i = 2;
                                                                                                this.a(var1, var2, var3);
                                                                                            }

                                                                                            return;
                                                                                        }

                                                                                        if (this.i == 0) {
                                                                                            this.i = 1;
                                                                                            this.a(var1);
                                                                                            return;
                                                                                        }

                                                                                        if (this.i == 1) {
                                                                                            this.i = 2;
                                                                                            this.a(var1, var2, var3);
                                                                                        }

                                                                                        return;
                                                                                    }

                                                                                    if (this.i == 0) {
                                                                                        this.i = 1;
                                                                                        this.a(var1);
                                                                                        return;
                                                                                    }

                                                                                    if (this.i == 1) {
                                                                                        this.i = 2;
                                                                                        this.a(var1, var2, var3);
                                                                                    }

                                                                                    return;
                                                                                }

                                                                                if (this.i == 0) {
                                                                                    this.i = 1;
                                                                                    this.a(var1);
                                                                                    return;
                                                                                }

                                                                                if (this.i == 1) {
                                                                                    this.i = 2;
                                                                                    this.a(var1, var2, var3);
                                                                                }

                                                                                return;
                                                                            }

                                                                            if (this.i == 0) {
                                                                                this.i = 1;
                                                                                this.a(var1);
                                                                                return;
                                                                            }

                                                                            if (this.i == 1) {
                                                                                this.i = 2;
                                                                                this.a(var1, var2, var3);
                                                                            }

                                                                            return;
                                                                        }

                                                                        if (this.i == 0) {
                                                                            this.i = 1;
                                                                            this.a(var1);
                                                                            return;
                                                                        }

                                                                        if (this.i == 1) {
                                                                            this.i = 2;
                                                                            this.a(var1, var2, var3);
                                                                        }

                                                                        return;
                                                                    }

                                                                    if (this.i == 0) {
                                                                        this.i = 1;
                                                                        this.a(var1);
                                                                        return;
                                                                    }

                                                                    if (this.i == 1) {
                                                                        this.i = 2;
                                                                        this.a(var1, var2, var3);
                                                                    }

                                                                    return;
                                                                }

                                                                if (this.i == 0) {
                                                                    this.i = 1;
                                                                    this.a(var1);
                                                                    return;
                                                                }

                                                                if (this.i == 1) {
                                                                    this.i = 2;
                                                                    this.a(var1, var2, var3);
                                                                }

                                                                return;
                                                            }

                                                            if (this.i == 0) {
                                                                this.i = 1;
                                                                this.a(var1);
                                                                return;
                                                            }

                                                            if (this.i == 1) {
                                                                this.i = 2;
                                                                this.a(var1, var2, var3);
                                                            }

                                                            return;
                                                        }

                                                        if (this.i == 0) {
                                                            this.i = 1;
                                                            this.a(var1);
                                                            return;
                                                        }

                                                        if (this.i == 1) {
                                                            this.i = 2;
                                                            this.a(var1, var2, var3);
                                                        }

                                                        return;
                                                    }

                                                    if (this.i == 0) {
                                                        this.i = 1;
                                                        this.a(var1);
                                                        return;
                                                    }

                                                    if (this.i == 1) {
                                                        this.i = 2;
                                                        this.a(var1, var2, var3);
                                                    }

                                                    return;
                                                }

                                                if (this.i == 0) {
                                                    this.i = 1;
                                                    this.a(var1);
                                                    return;
                                                }

                                                if (this.i == 1) {
                                                    this.i = 2;
                                                    this.a(var1, var2, var3);
                                                    return;
                                                }

                                                return;
                                            }

                                            if (this.i == 0) {
                                                this.i = 1;
                                                this.a(var1);
                                                return;
                                            }

                                            if (this.i == 1) {
                                                this.i = 2;
                                                this.a(var1, 0, 0);
                                            }

                                            return;
                                        }

                                        if (this.i == 0) {
                                            this.i = 1;
                                            this.a(var1);
                                            return;
                                        }

                                        if (this.i == 1) {
                                            this.i = 2;
                                            this.a(var1, var2, var3);
                                            return;
                                        }

                                        return;
                                    }

                                    if (this.i == 0) {
                                        this.i = 1;
                                        this.a(var1);
                                        return;
                                    }

                                    if (this.i == 1) {
                                        this.i = 2;
                                        this.a(var1, var2, var3);
                                    }

                                    return;
                                }

                                if (this.i == 0) {
                                    this.i = 1;
                                    this.a(var1);
                                    return;
                                }

                                if (this.i == 1) {
                                    this.i = 2;
                                    this.a(var1, var2, var3);
                                }

                                return;
                            }

                            if (this.i == 0) {
                                this.i = 1;
                                this.a(var1);
                                return;
                            }

                            if (this.i == 1) {
                                this.i = 2;
                                this.a(var1, var2, var3);
                            }

                            return;
                        }

                        if (this.i == 0) {
                            this.i = 1;
                            this.a(var1);
                            return;
                        }

                        if (this.i == 1) {
                            this.i = 2;
                            this.a(var1, var2, var3);
                        }

                        return;
                    }

                    if (this.i == 0) {
                        this.i = 1;
                        this.a(var1);
                        return;
                    }

                    if (this.i == 1) {
                        this.i = 2;
                        this.a(var1, var2, var3);
                    }

                    return;
                }

                if (this.i == 0) {
                    this.i = 1;
                    this.a(var1);
                    return;
                }

                if (this.i == 1) {
                    this.i = 2;
                    this.a(var1, var2, var3);
                }

                return;
            }

            if (this.i == 0) {
                this.i = 1;
                this.a(var1);
                return;
            }

            if (this.i == 1) {
                this.i = 2;
                this.a(var1, var2, var3);
            }

            return;
        }

        if (this.i == 0) {
            this.i = 1;
            this.a(var1);
        } else {
            if (this.i == 1) {
                this.i = 2;
                this.a(var1, var2, var3);
            }

        }
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (!this.u && !this.v) {
            if (var1.j == null || !(var1.j instanceof LangLa_ik)) {
                this.s.b(var1.b, this.g, this);
                if (var1.b >= 1020 && var1.b < 1030) {
                    return;
                }

                switch (this.d) {
                    case -13:
                    case -12:
                    case 17:
                        return;
                    case -11:
                    case 59:
                        LangLa_dp var5;
                        if (!(var5 = LangLa_dp.a()).a) {
                            try {
                                if (var5.b[1] != null) {
                                    var5.b[1].play();
                                }
                                break;
                            } catch (Exception var4) {
                                Utlis.println(var4);
                            }
                        }

                        return;
                    case 6:
                        LangLa_dp.a().m();
                        return;
                    default:
                        LangLa_dp.a().h();
                }
            }

        }
    }

    public Vector c() {
        Vector var1 = new Vector();
        if (!this.u && !this.v) {
            var1.addElement(new LangLa_jz(this.b, 0, 0, this.width, this.height, (LangLa_ii) null, this));
        }

        return var1;
    }

    public boolean a() {
        if (!this.u && !this.v) {
            if (this.i == 1) {
                return true;
            } else {
                return this.h ? true : this.n(0);
            }
        } else {
            return false;
        }
    }
}
