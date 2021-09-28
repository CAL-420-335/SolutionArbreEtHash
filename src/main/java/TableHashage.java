import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TableHashage<T> {

    List<T>[] buckets;

    public TableHashage(int size) {
        buckets = new List[size];
        for(int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean ajouter(T valeur) {
        if(contient(valeur)) return false;
        buckets[idx(valeur)].add(valeur);
        return true;
    }

    public boolean contient(T valeur) {
        return get(valeur) != null;
    }

    public T get(T valeur) {
        for(T v : buckets[idx(valeur)]) {
            if(v.equals(valeur)) return v;
        }

        return null;
    }

    public int idx(T valeur) {
        return Math.abs(valeur.hashCode()) % buckets.length;
    }


}
