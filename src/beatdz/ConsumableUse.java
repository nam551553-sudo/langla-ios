package beatdz;

/** One inventory scan preserves level and bound-item priority without sorting temporary vectors. */
final class ConsumableUse {
    private ConsumableUse() { }

    static Item choose(Item[] bag, int type, int playerLevel, int levelLimit, int map) {
        if (bag == null) return null;
        Item best = null;
        for (Item item : bag) {
            if (item == null || item.getAmount() <= 0) continue;
            ItemTemplate template = item.getItemTemplate();
            if (template == null || template.levelNeed > playerLevel || template.levelNeed > levelLimit) continue;
            boolean matching = type == 22 && map == 45 ? item.id == 659 : template.type == type;
            if (!matching) continue;
            if (best == null || Item.$state_Item().a.compare(item, best) < 0) best = item;
        }
        return best;
    }

    static int levelLimit(int selection) {
        switch (selection) {
            case 1: return 55;
            case 2: return 50;
            case 3: return 40;
            case 4: return 30;
            case 5: return 20;
            case 6: return 10;
            default: return Integer.MAX_VALUE;
        }
    }
}
