package beatdz;
import java.util.Comparator;

 class LangLa_el implements Comparator {
    LangLa_el() {
    }

    
    public int compare(Object obj, Object obj2) {
        return ((LangLa_ek) obj).b - ((LangLa_ek) obj2).b;
    }
}
