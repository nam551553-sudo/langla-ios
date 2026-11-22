package beatdz;
import java.util.Comparator;

 class LangLa_hc implements Comparator {
    LangLa_hc() {
    }

    
    public int compare(Object obj, Object obj2) {
        return ((LangLa_hb) obj).c - ((LangLa_hb) obj2).c;
    }
}
