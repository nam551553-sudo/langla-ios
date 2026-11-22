package com.langla.j2me;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;

public final class ConnectionMidlet extends MIDlet implements CommandListener {
    private final Form screen = new Form("Làng Lá Blue");
    private final TextField host = new TextField("Máy chủ", "103.77.172.222", 253, TextField.ANY);
    private final TextField port = new TextField("Cổng", "2907", 5, TextField.NUMERIC);
    private final StringItem status = new StringItem(null, "Bản thử kết nối J2ME");
    private final Command connect = new Command("Kiểm tra", Command.OK, 1);
    private final Command exit = new Command("Thoát", Command.EXIT, 2);
    private final Command login = new Command("Đăng nhập", Command.SCREEN, 1);
    private final Command back = new Command("Quay lại", Command.BACK, 2);
    private final TextField username = new TextField("Tài khoản", "", 64, TextField.NON_PREDICTIVE);
    private final TextField password = new TextField("Mật khẩu", "", 64, TextField.PASSWORD);
    private final LoginCanvas canvas = new LoginCanvas(this);
    private String[][] servers = {{"Lục Đạo", "103.77.172.222", "2907"}};
    private int server;
    private List serverList;
    private boolean started;
    private LoginSession session;
    private boolean busy;

    public ConnectionMidlet() {
        screen.append(host);
        screen.append(port);
        screen.append(username);
        screen.append(password);
        screen.append(status);
        screen.addCommand(connect);
        screen.addCommand(login);
        screen.addCommand(exit);
        screen.addCommand(back);
        screen.setCommandListener(this);
    }

    protected void startApp() {
        if (started) return;
        started = true;
        Display.getDisplay(this).setCurrent(canvas);
        new Thread(new Runnable() {
            public void run() {
                try {
                    final String[][] available = WebAssets.servers();
                    Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                        public void run() {
                            if (serverList == null) {
                                servers = available;
                                canvas.repaint();
                            }
                        }
                    });
                } catch (Exception unavailable) { }
            }
        }).start();
    }

    protected void pauseApp() { }

    protected void destroyApp(boolean unconditional) { closeSession(); }

    public void commandAction(Command command, Displayable view) {
        if (command == exit) {
            closeSession();
            notifyDestroyed();
        } else if (command == connect) {
            checkConnection();
        } else if (command == login) {
            startLogin();
        } else if (command == back) {
            closeSession();
            serverList = null;
            canvas.repaint();
            Display.getDisplay(this).setCurrent(canvas);
        } else if (command == List.SELECT_COMMAND && view == serverList && serverList != null) {
            server = serverList.getSelectedIndex();
            serverList = null;
            canvas.repaint();
            Display.getDisplay(this).setCurrent(canvas);
        } else if (command == List.SELECT_COMMAND && view instanceof List && session != null && !busy) {
            selectCharacter(((List) view).getSelectedIndex());
        }
    }

    String[] loginRows() {
        return new String[]{
                "Máy chủ: ".concat(servers[server][0]).concat("  ▼"),
                "Tài khoản: ".concat(username.getString()),
                password.size() == 0 ? "Mật khẩu" : "Mật khẩu: ••••••",
                "Đăng ký", "Vào Game", "Dữ liệu web"
        };
    }

    String loginStatus() { return status.getText(); }

    void loginAction(int row) {
        if (busy) return;
        if (row == 0) {
            serverList = new List("Máy chủ", List.IMPLICIT);
            for (int i = 0; i < servers.length; i++) serverList.append(servers[i][0], null);
            serverList.setSelectedIndex(server, true);
            serverList.addCommand(back);
            serverList.setCommandListener(this);
            Display.getDisplay(this).setCurrent(serverList);
        } else if (row == 1 || row == 2) {
            Display.getDisplay(this).setCurrent(screen);
        } else if (row == 3) {
            try {
                if (platformRequest("https://langlaanhhung.vn/")) notifyDestroyed();
            } catch (Exception unavailable) {
                status.setText("Không mở được trang đăng ký.");
                canvas.repaint();
            }
        } else if (row == 4) {
            host.setString(servers[server][1]);
            port.setString(servers[server][2]);
            startLogin();
            canvas.repaint();
        } else if (row == 5) {
            checkWebAssets();
        }
    }

    private void checkWebAssets() {
        busy = true;
        status.setText("Đang tải dữ liệu web...");
        canvas.repaint();
        new Thread(new Runnable() {
            public void run() {
                try {
                    final int size = WebAssets.gameData().length;
                    final javax.microedition.lcdui.Image sample = WebAssets.characterImage(30600);
                    Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                        public void run() {
                            busy = false;
                            Form report = new Form("Dữ liệu web");
                            report.append(new StringBuffer("Đã tải bảng game: ").append(size).append(" byte").toString());
                            report.append(sample);
                            report.addCommand(back);
                            report.setCommandListener(ConnectionMidlet.this);
                            Display.getDisplay(ConnectionMidlet.this).setCurrent(report);
                        }
                    });
                } catch (Exception unavailable) {
                    Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                        public void run() {
                            busy = false;
                            status.setText("Tải dữ liệu web thất bại.");
                            canvas.repaint();
                        }
                    });
                }
            }
        }).start();
    }

    private void startLogin() {
        if (busy) return;
        final String endpoint = endpoint();
        final String account = username.getString().trim();
        final String secret = password.getString();
        if (endpoint == null || account.length() == 0 || secret.length() == 0) {
            status.setText("Nhập máy chủ, cổng, tài khoản và mật khẩu hợp lệ.");
            return;
        }
        password.setString("");
        closeSession();
        final LoginSession attempt = new LoginSession();
        session = attempt;
        busy = true;
        status.setText("Đang đăng nhập...");
        new Thread(new Runnable() {
            public void run() {
                try {
                    final String[] names = attempt.login(endpoint, account, secret);
                    Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                        public void run() {
                            if (session != attempt) return;
                            busy = false;
                            if (names.length == 0) {
                                closeSession();
                                status.setText("Tài khoản chưa có nhân vật.");
                                canvas.repaint();
                                return;
                            }
                            List roster = new List("Chọn nhân vật", List.IMPLICIT);
                            for (int i = 0; i < names.length; i++) roster.append(names[i], null);
                            roster.addCommand(back);
                            roster.setCommandListener(ConnectionMidlet.this);
                            Display.getDisplay(ConnectionMidlet.this).setCurrent(roster);
                        }
                    });
                } catch (Exception failure) {
                    finish(attempt, failure.getMessage());
                }
            }
        }).start();
    }

    private void selectCharacter(final int index) {
        if (index < 0) return;
        final LoginSession attempt = session;
        busy = true;
        new Thread(new Runnable() {
            public void run() {
                try {
                    final MapCanvas map = attempt.openMap(attempt.selectCharacter(index));
                    Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                        public void run() {
                            if (session != attempt) return;
                            busy = false;
                            map.addCommand(back);
                            map.setCommandListener(ConnectionMidlet.this);
                            Display.getDisplay(ConnectionMidlet.this).setCurrent(map);
                            loadMapImage(attempt, map);
                            new Thread(new Runnable() {
                                public void run() { map.play(attempt); }
                            }).start();
                        }
                    });
                    attempt.keepReceiving();
                } catch (Exception failure) {
                    finish(attempt, failure.getMessage());
                }
            }
        }).start();
    }

    private void loadMapImage(final LoginSession attempt, final MapCanvas map) {
        final int width = map.getWidth();
        final int height = map.getHeight();
        new Thread(new Runnable() {
            public void run() {
                final javax.microedition.lcdui.Image[] terrain = map.loadTerrain(width, height);
                javax.microedition.lcdui.Image image = null;
                if (terrain == null) {
                    try { image = WebAssets.mapImage(map.mapId); }
                    catch (Exception unavailable) { }
                }
                final javax.microedition.lcdui.Image loaded = image;
                Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                    public void run() {
                        if (session != attempt) return;
                        if (terrain != null) map.setTerrain(terrain);
                        else map.setMap(loaded);
                    }
                });
            }
        }).start();
    }

    private void finish(final LoginSession attempt, final String message) {
        attempt.close();
        Display.getDisplay(this).callSerially(new Runnable() {
            public void run() {
                if (session != attempt) return;
                session = null;
                busy = false;
                status.setText(message == null ? "Kết nối đã đóng." : message);
                canvas.repaint();
                Display.getDisplay(ConnectionMidlet.this).setCurrent(canvas);
            }
        });
    }

    private void closeSession() {
        if (session != null) {
            session.close();
            session = null;
        }
        busy = false;
    }

    private void checkConnection() {
        if (busy) return;
        final String endpoint = endpoint();
        if (endpoint == null) {
            status.setText("Nhập tên máy chủ hoặc IPv4 và cổng hợp lệ.");
            return;
        }
        busy = true;
        screen.removeCommand(connect);
        status.setText("Đang kết nối...");
        new Thread(new Runnable() {
            public void run() {
                final String result = probe(endpoint);
                Display.getDisplay(ConnectionMidlet.this).callSerially(new Runnable() {
                    public void run() {
                        busy = false;
                        status.setText(result);
                        screen.addCommand(connect);
                    }
                });
            }
        }).start();
    }

    private String endpoint() {
        String address = host.getString().trim();
        int number;
        try {
            number = Integer.parseInt(port.getString());
        } catch (NumberFormatException invalid) {
            number = 0;
        }
        if (!validHost(address) || number < 1 || number > 65535) {
            return null;
        }

        return new StringBuffer("socket://").append(address).append(':').append(number).toString();
    }

    private static boolean validHost(String address) {
        if (address.length() == 0) {
            return false;
        }
        for (int index = 0; index < address.length(); index++) {
            char c = address.charAt(index);
            if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
                    || c >= '0' && c <= '9' || c == '.' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    private static String probe(String endpoint) {
        SocketConnection socket = null;
        try {
            socket = (SocketConnection) Connector.open(endpoint, Connector.READ_WRITE, true);
            return "Kết nối TCP thành công.";
        } catch (SecurityException denied) {
            return "Trình giả lập chưa cấp quyền kết nối mạng.";
        } catch (IOException unavailable) {
            return "Không kết nối được. Kiểm tra mạng, địa chỉ và cổng.";
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ignored) { }
            }
        }
    }
}
