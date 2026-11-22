package beatdz;

public final class EquipmentTapScenario {
    private EquipmentTapScenario() { }

    public static void verify() {
        MultiSession.select(0);
        DataCenter data = DataCenter.gI();
        ItemTemplate[] templates = data.ItemTemplate;
        DataTypeItemBody[] types = data.DataTypeItemBody;
        SkillTemplate[] skillTemplates = data.SkillTemplate;
        Skill[] skills = data.Skill;
        long[] exps = data.exps;
        Char player = Char.gI();
        Item[] bag = player.arrItemBag;
        Item equipped = player.arrItemBody[1];
        String name = player.name;
        GameSrc game = GameSrc.gI();
        int previousTab = game.aw;
        try {
            player.name = "TrangBiTest";
            ItemTemplate weapon = new ItemTemplate(1);
            weapon.type = 1;
            weapon.name = "Vũ khí kiểm tra";
            weapon.gioiTinh = 2;
            weapon.detail = "";
            data.ItemTemplate = new ItemTemplate[]{null, weapon};
            DataTypeItemBody type = new DataTypeItemBody();
            type.type = 1;
            data.DataTypeItemBody = new DataTypeItemBody[]{type};
            SkillTemplate skillTemplate = new SkillTemplate(0);
            skillTemplate.name = "Chiêu thức kiểm tra";
            skillTemplate.levelMax = 1;
            Skill skill = new Skill() {
                @Override public ItemOption[] g() { return new ItemOption[0]; }
            };
            skill.level = 1;
            data.SkillTemplate = new SkillTemplate[]{skillTemplate};
            data.Skill = new Skill[]{skill};
            data.exps = new long[]{100000L};
            player.arrItemBody[1] = new Item(1);
            player.arrItemBag = new Item[27];
            player.arrItemBag[0] = new Item(1);
            game.aw = 0;
            LangLa_kl panel = new LangLa_kl(game, player, data.Skill);
            check(!panel.d, "exercise the first tap while profile details are pending");

            tap(panel, 1011);
            checkAction(panel, 105, player.arrItemBody[1]);
            panel.b((LangLa_cs)panel.cL);
            panel.a(panel.j());
            tap(panel, 5001);
            checkAction(panel, 104, player.arrItemBag[0]);
        } finally {
            game.aw = previousTab;
            player.name = name;
            player.arrItemBag = bag;
            player.arrItemBody[1] = equipped;
            data.ItemTemplate = templates;
            data.DataTypeItemBody = types;
            data.SkillTemplate = skillTemplates;
            data.Skill = skills;
            data.exps = exps;
        }
    }

    private static void tap(LangLa_kl panel, int regionId) {
        panel.M();
        for (LangLa_jz region : panel.cP.a) {
            if (region.b == regionId) {
                int x = panel.cx + region.c + 12, y = panel.cy + region.d + 12;
                panel.f(x, y);
                panel.g(x, y);
                return;
            }
        }
        throw new AssertionError("equipment region " + regionId);
    }

    private static void checkAction(LangLa_kl panel, int action, Item item) {
        check(panel.cL instanceof LangLa_mq, "one tap must open the item menu");
        LangLa_mq menu = (LangLa_mq) panel.cL;
        check(menu.a.b == item, "menu points to the selected equipment");
        boolean details = false, canAct = false;
        for (Object entry : menu.c()) {
            int id = ((LangLa_jz) entry).b;
            details |= id == 1010;
            canAct |= id == action;
        }
        check(details && canAct, "details and the relevant action appear together");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
