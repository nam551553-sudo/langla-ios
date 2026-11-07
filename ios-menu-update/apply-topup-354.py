from pathlib import Path

path = Path("src/beatdz/GameSrc.java")
source = path.read_text(encoding="utf-8")
old = """                    } catch (Exception var21) {
                    }
                case 41:
                    GoldTopUpPanel topup"""
new = """                    } catch (Exception var21) {
                    }
                    return;
                case 41:
                    String title = var1.readUTF();
                    String details = var1.readUTF();
                    String imageUrl = var1.readUTF();
                    GoldTopUpPanel topup"""
old_receive = "topup.receive(var1.readUTF(), var1.readUTF(), var1.readUTF());"
assert source.count(old) == source.count(old_receive) == 1
path.write_text(source.replace(old, new).replace(old_receive, "topup.receive(title, details, imageUrl);"), encoding="utf-8")