import java.util.Objects;

public class keyValue <K extends Comparable<K>, V extends Comparable<V>> implements Comparable<keyValue<K, V>> {
    K key;
    V value;

    public keyValue(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        keyValue<?, ?> keyValue = (keyValue<?, ?>) o;
        return Objects.equals(key, keyValue.key) && Objects.equals(value, keyValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public int compareTo(keyValue<K, V> other) {
        return this.key.compareTo(other.key);
    }
}
