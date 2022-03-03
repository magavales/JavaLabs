import java.util.Objects;

public class HashMap <K extends Comparable<K>, V extends Comparable<V>> {
    static final int DEFAULT_INITIAL_CAPACITY= 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;

    transient Node<K, V>[] table;
    int size;
    int threshold;
    float loadFactor;
    int bucketCount = 0;

    /**
     * Конструктор по умолчанию
     */
    public HashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Конструктор
     * @param initialCapacity начальный объем таблицы
     */
    public HashMap(int initialCapacity){
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Конструктор
     * @param initialCapacity начальный объем таблицы
     * @param loadFactor коэффициент загруженности
     */
    public HashMap(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY){
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        this.loadFactor = loadFactor;
        this.threshold = (int)(initialCapacity * loadFactor);
        table = new Node[initialCapacity];
    }

    /**
     * Помещает новую пару ключ-значение в {@code hashmap}
     * @param key Ключ
     * @param value Значение
     */
    public void put(K key, V value){
        int hashCode = hash(key.hashCode());
        int index = (table.length - 1) & hashCode;
        Node<K, V> newNode = new Node<>(key, value, hashCode);

        if(table == null){
            table[index] = newNode;
        }
        else {
            if (table[index] == null){
                table[index] = newNode;
            }
            else{
                if (table[index].hash == newNode.hash && table[index].key == newNode.key) {
                    table[index].value = newNode.value;
                }
                if (table[index].hash == newNode.hash && table[index].key != newNode.key){
                    table[index].next = newNode;
                }
            }
        }

        size++;
        if (checkTable() == false){
            resize(2 * table.length + 1);
        }

    }

    /**
     * Достает из {@code hashmap} значение соответсвующее ключу
     * @param key Ключ
     * @return Значение по ключу или null если такого ключа не существует
     */
    public V get(K key){
        Objects.requireNonNull(key);
        int hash = hash(key.hashCode());
        for (Node<K,V> temp = table[(table.length - 1) & hash]; temp != null; temp = temp.next) {
            if (temp.hash == hash && (temp.key == key || key.equals(temp.key)))
                return temp.value;
        }
        return null;
    }

    public V remove(K key) {
        Node<K,V> e = removeNodeForKey(key);
        return (e == null ? null : e.value);
    }

    public Node<K, V> removeNodeForKey(K key){
        int hash = hash(key.hashCode());
        int i = (table.length - 1) & hash;
        Node<K,V> temp = table[i];
        Node<K,V> e = temp;

        while (e != null) {
            Node<K,V> next = e.next;
            Object k;
            if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                size--;
                if (temp == e)
                    table[i] = next;
                else
                    temp.next = next;
                e.recordRemoval(this);
                return e;
            }
            temp = e;
            e = next;
        }

        return e;
    }

    public int getSize(){
        return this.size;
    }

    public float getLoadFactor(){
        return this.loadFactor;
    }

    public void newLoadFactor(float newLoadFactor){
        this.loadFactor = newLoadFactor;
    }

    /**
     * Удаляет все элементы из {@code hashmap}
     */
    public void clear() {
        Node[] tab = table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        size = 0;
    }

    public void transfer(Node<K, V>[] newTable){
        Node[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Node<K,V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Node<K,V> next = e.next;
                    int i = (table.length - 1) & e.hash;
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    public void resize(int newCapacity){
        if (table.length == MAXIMUM_CAPACITY)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Node<K, V>[] newTable = new Node[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    public boolean checkTable(){
        Node<K, V> tempNode;
        if (size > threshold){
            return false;
        }
        for (int i = 0; i < table.length; i++){
            if (table[i] != null){
                for (int binCount = 0; ; binCount++){
                    if (binCount == 1){
                        bucketCount++;
                    }
                    if (table[i].next != null){
                        tempNode = table[i].next;
                    }
                    else {
                        break;
                    }
                    if (binCount >= TREEIFY_THRESHOLD - 1 && bucketCount < 64){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }



}
