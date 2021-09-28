import java.util.Objects;

public class PaireCleValeur <K extends Comparable<K>, V> implements Comparable<PaireCleValeur<K,V>> {

    public K cle;
    public V val;

    public PaireCleValeur(K cle, V val) {
        this.cle = cle;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof  PaireCleValeur)) return false;
        PaireCleValeur<K, V> kv = (PaireCleValeur<K, V>) o;

        return cle.equals(kv.cle);
    }

    @Override
    public int hashCode(){
        return Objects.hash(cle);
    }

    @Override
    public int compareTo(PaireCleValeur<K, V> o) {
        if(o == null) return 1;
        return cle.compareTo(o.cle);
    }
}
