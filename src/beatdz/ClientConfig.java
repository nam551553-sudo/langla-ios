package beatdz;

/** Shared endpoints for desktop, Android and iOS builds. */
public final class ClientConfig {
    public static final String SERVER_IP = "103.77.172.222";
    public static final String DATA_URL = "http://103.77.172.222/langlaapp/";
    public static final String SERVER_LIST_URL = DATA_URL + "serverlist.txt";
    public static final String DEFAULT_SERVER_LIST =
            "id = S1\r\nLục Đạo = 1:" + SERVER_IP + ":2907:2908";

    private ClientConfig() { }
}
