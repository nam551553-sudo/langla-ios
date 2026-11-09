package beatdz;

/** Visible app branding and system notices shared by all game platforms. */
public final class GameBrand {
    public static final String NAME = "Làng Lá Blue";
    public static final String WELCOME = "Chào mừng bạn đến với Làng Lá Blue";
    private static final java.util.regex.Pattern OLD_NAME =
            java.util.regex.Pattern.compile("làng lá test", java.util.regex.Pattern.CASE_INSENSITIVE | java.util.regex.Pattern.UNICODE_CASE);

    public static String systemNotice(String text) {
        return text == null ? null : OLD_NAME.matcher(text).replaceAll(NAME);
    }

    private GameBrand() { }
}
