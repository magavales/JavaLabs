public class Node <K extends Comparable<K>, V extends Comparable<V>> {
    int hash;               //хэш
    K key;                  //значение ключа
    V value;                //данные
    Node<K, V> next;        //ссылка на следущий элемент

    /**
     * Конструктор ячейки таблицы
     * @param key Ключ
     * @param value Значение
     * @param hash Хэш
     */
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

}
