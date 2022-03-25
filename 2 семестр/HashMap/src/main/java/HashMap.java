import java.util.Arrays;
import java.util.Objects;

public class HashMap <K extends Comparable<K>, V extends Comparable<V>> {
    static final int DEFAULT_INITIAL_CAPACITY= 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 2.0f;
    static final int TREEIFY_THRESHOLD = 8;

    transient Node<K, V>[] table;
    int size;                           //количество элементов
    int threshold;                      //предельное количество элементов, при достижение которого таблица перехэшировается
    float loadFactor;                   //степень загруженности
    int bucketCount = 0;                //количество связных списков

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

    public HashMap(HashMap<K,V> map) {
        this(map.table.length, map.loadFactor);

        for (int i = 0; i < map.table.length; i++){
            for (Node<K, V> temp = map.table[i]; temp != null; temp = temp.next){
                this.put(temp.key, temp.value);
            }
        }
    }

    /**
     * Помещает новую пару ключ-значение в {@code hashmap}
     * @param key Ключ
     * @param value Значение
     */
    public void put(K key, V value){
        int hashCode = hash(key.hashCode());
        int index = hashCode & (table.length - 1);
        Node<K, V> newNode = new Node<>(key, value, hashCode);

        if(table == null){
            table[index] = newNode;
        }
        else {
            if (table[index] == null){
                table[index] = newNode;
                size++;
            }
            else{
                if (table[index].hash == newNode.hash && table[index].key == newNode.key) {
                    table[index].value = newNode.value;
                }
                if (table[index].hash == newNode.hash && table[index].key != newNode.key){
                    table[index].next = newNode;
                    size++;
                }
                if (table[index].hash != newNode.hash && table[index].key != newNode.key){
                    table[index].next = newNode;
                    size++;
                }
            }
        }

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

    /**
     * Удаляет ячейку по ключу из {@code hashmap}
     * @param key Ключ
     */
    public void remove(K key){
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int i = hash & (table.length - 1);
        Node<K,V> prev = table[i];
        Node<K,V> e = prev;

        while (e != null) {
            Node<K,V> next = e.next;
            Object k;
            if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                size--;
                if (prev == e)
                    table[i] = next;
                else
                    prev.next = next;
            }
            prev = e;
            e = next;
        }
    }

    /**
     * Получение числа элементов из {@code hashmap}
     * @return Число элементов
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Получение максимальной загруженности из {@code hashmap}
     * @return Максимальная загруженность
     */
    public float getLoadFactor(){
        return this.loadFactor;
    }

    /**
     * Изменение максимальное загруженности в {@code hashmap}
     * @param newLoadFactor Новое значение максимальной загруженности
     */
    public void newLoadFactor(float newLoadFactor){
        this.loadFactor = newLoadFactor;
    }

    /**
     * Проверка очереди на пустоту
     *
     * @return Возвращает True, если очередь пуста, и False - в противном случае.
     */
    public boolean isEmpty(){
        return size == 0;
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

    /**
     * Переносит все записи из текущей таблицы в новую таблицу
     * @param newTable Новая таблица
     */
    public void transfer(Node<K, V>[] newTable){
        Node[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Node<K,V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Node<K,V> next = e.next;
                    int i = e.hash & (table.length - 1);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    /**
     * Перехэширование элементов текущей таблицы в новую таблицу
     * @param newCapacity Новый размер таблицы
     */
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

    /**
     * Проверка таблицы на необходимость проводить перехэширование
     * @return true - если необходимо произвести перехэширование, false - в противном случае
     */
    public boolean checkTable(){
        int count = 0;

        Node<K, V> tempNode;
        if (size > threshold){
            return false;
        }
        for (int i = 0; i < table.length; i++){
            if (table[i] != null){
                tempNode = table[i];
                for (int binCount = 0; ; binCount++){
                    if (binCount == 1){
                        count++;
                    }
                    if (tempNode.next != null){
                        tempNode = tempNode.next;
                    }
                    else {
                        break;
                    }
                    if (binCount >= TREEIFY_THRESHOLD - 1 && bucketCount < 64){
                        return false;
                    }
                }
                bucketCount = count;
            }
        }

        return true;
    }

    /**
     * Вычисление хэша ключа
     * @param h Хэш код ключа, вычисленный при помощи встроенной функции
     * @return Хэш код ключа
     */
    public int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMap<?, ?> hashMap = (HashMap<?, ?>) o;
        return size == hashMap.size && threshold == hashMap.threshold && Float.compare(hashMap.loadFactor, loadFactor) == 0 && bucketCount == hashMap.bucketCount && Arrays.equals(table, hashMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, threshold, loadFactor, bucketCount);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}
