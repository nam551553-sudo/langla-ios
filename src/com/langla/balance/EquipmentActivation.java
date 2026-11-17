package com.langla.balance;

/** Stateless rules shared by the server and every client; never cache a wearer's state. */
public final class EquipmentActivation {
    private EquipmentActivation() { }

    public static int supportType(int type, int index) {
        switch (type) {
            case 0: return index == 0 ? 3 : 4;
            case 2: return index == 0 ? 7 : 8;
            case 3: return index == 0 ? 0 : 4;
            case 4: return index == 0 ? 0 : 3;
            case 5: return index == 0 ? 6 : 9;
            case 6: return index == 0 ? 5 : 9;
            case 7: return index == 0 ? 2 : 8;
            case 8: return index == 0 ? 2 : 7;
            case 9: return index == 0 ? 6 : 5;
            default: return -1;
        }
    }

    public static boolean validElement(int element) {
        return element >= 1 && element <= 5;
    }

    public static int hiddenLineCount(int type, int element, int characterElement,
            int weaponElement, int tantoElement, boolean universalTanto,
            int firstSupportElement, int secondSupportElement) {
        if (type == 1) {
            return validElement(element) && (element == characterElement
                    || element == tantoElement || universalTanto) ? 3 : 0;
        }
        if (type == 15) {
            return validElement(weaponElement) && (element == weaponElement || universalTanto) ? 3 : 0;
        }
        if (supportType(type, 0) >= 0) {
            if (!validElement(element)) return 0;
            return (element == firstSupportElement ? 1 : 0) + (element == secondSupportElement ? 1 : 0);
        }
        // Pet, costume, cape and book options have no elemental equipment requirement.
        return Integer.MAX_VALUE;
    }

    public static int tantoMarker(int element) {
        return 131 + (validElement(element) ? element - 1 : 0);
    }
}
