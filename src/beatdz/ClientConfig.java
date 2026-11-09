package beatdz;

/** Shared endpoints for desktop, Android and iOS builds. */
public final class ClientConfig {
    public static final String SERVER_IP = com.langla.config.Endpoints.SERVER_IP;
    public static final String DATA_URL = com.langla.config.Endpoints.DATA_URL;
    public static final String SERVER_LIST_URL = DATA_URL + "serverlist.txt";
    public static final String DEFAULT_SERVER_LIST =
            "id = S1\r\nLục Đạo = 1:" + SERVER_IP + ":2907:2908";

    private ClientConfig() { }
}

