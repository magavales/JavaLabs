public class Node <K extends Comparable<K>, V extends Comparable<V>> {
    int hash;
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value, int hash){
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }

    public final int hashCode() {
        return (key==null   ? 0 : key.hashCode()) ^
                (value==null ? 0 : value.hashCode());
    }

    void recordRemoval(HashMap<K,V> m) {
    }
}
