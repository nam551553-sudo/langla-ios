package beatdz;

/** Restores each account after an unexpected disconnect using its existing login path. */
final class AccountReconnect {
    private static final long LOGIN_TIMEOUT_MS = 45_000;
    private boolean armed;
    private boolean restoring;
    private boolean attemptStarted;
    private boolean selectedCharacter;
    private boolean resumeTraining;
    private int characterId;
    private int failures;
    private String username;
    private String password;
    private Server server;
    private long nextAttemptAt;
    private long attemptDeadline;

    static AccountReconnect gI() {
        return $state().value;
    }

    void cancel() {
        armed = false;
        restoring = false;
        attemptStarted = false;
        selectedCharacter = false;
    }

    void observe() {
        DataCenter data = DataCenter.gI();
        Session session = Session.gI();
        if (!restoring) {
            if (session.isConnected() && data.currentScreen instanceof GameSrc && Char.gI().idEntity > 0) {
                remember();
            }
            return;
        }
        long now = Utlis.time();
        if (attemptStarted && session.isConnected() && data.currentScreen instanceof GameSrc
                && !data.aH && GameSrc.gI().V == null && Char.gI().idEntity == characterId) {
            SettingsTab.gI().a(resumeTraining);
            restoring = false;
            attemptStarted = false;
            failures = 0;
            remember();
            return;
        }
        if (attemptStarted && session.isConnected() && data.currentScreen instanceof SelectCharScreen && !selectedCharacter) {
            selectedCharacter = ((SelectCharScreen)data.currentScreen).reselectCharacter(characterId);
            if (!selectedCharacter) {
                cancel();
                data.currentScreen.showMessage("Không tìm thấy nhân vật trước khi mất kết nối.", -65536);
            }
            return;
        }
        if (attemptStarted && now < attemptDeadline) return;
        if (attemptStarted) {
            attemptStarted = false;
            session.close();
        }
        if (now < nextAttemptAt || session.isConnecting) return;
        startAttempt(now);
    }

    private void remember() {
        String name = AutoPro.$state_AutoPro().tk;
        String secret = AutoPro.$state_AutoPro().mk;
        if (name == null || name.isEmpty() || secret == null || secret.isEmpty()) return;
        username = name;
        password = secret;
        server = DataCenter.gI().aP;
        characterId = Char.gI().idEntity;
        resumeTraining = SettingsTab.gI().autoTrain;
        armed = server != null;
    }

    boolean disconnected() {
        if (!armed) return false;
        if (!restoring) {
            resumeTraining = SettingsTab.gI().autoTrain;
            restoring = true;
        }
        attemptStarted = false;
        selectedCharacter = false;
        nextAttemptAt = Utlis.time() + retryDelay(failures++, MultiSession.current().slot);
        DataCenter.gI().setScreen(LoginPCScreen.gI());
        return true;
    }

    private void startAttempt(long now) {
        attemptStarted = true;
        selectedCharacter = false;
        attemptDeadline = now + LOGIN_TIMEOUT_MS;
        DataCenter data = DataCenter.gI();
        data.setServer(server);
        LoginPCScreen screen = (LoginPCScreen)LoginPCScreen.gI();
        screen.a.a(username);
        screen.b.a(password);
        data.setScreen(screen);
        screen.k();
    }

    static long retryDelay(int failures, int slot) {
        return Math.min(30_000L, 3_000L << Math.min(4, Math.max(0, failures))) + slot * 650L;
    }

    boolean restoring() { return restoring; }

    private static final class State implements MultiSession.State {
        final AccountReconnect value = new AccountReconnect();
        public void initialize() { }
    }

    private static final int STATE = MultiSession.register("beatdz.AccountReconnect");
    private static State $state() { return MultiSession.state(STATE, State::new); }
}
