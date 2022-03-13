import java.util.Objects;

public class Map <K extends Comparable<K>, V extends Comparable<V>>{
    RedBlackTree<keyValue<K, V>> tree;

    /**
     * Конструктор по умолчанию
     */
    public Map() {
        tree = new RedBlackTree<>();
    }

    /**
     * Конструктор копирования. Используется рекурентная реализация
     * @param other Другой {@code map}
     */
    public Map(Map<K, V> other) {
        tree = new RedBlackTree<>(other.tree);
    }

    /**
     * Помещает новую пару ключ-значение в {@code map}
     * @param key Ключ
     * @param value Значение
     */
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        tree.insert(new keyValue<>(key, value));
    }

    /**
     * Удаляет все элементы из {@code map}
     */
    public void clear() {
        tree.clear(); // Delete all subtree
    }

    /**
     * Проверка {@code map} на пустоту
     * @return Результат проверки на пустоту
     */
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * Достает из {@code map} значение соответсвующее ключу
     * @param key Ключ
     * @return Значение по ключу или null если такого ключа не существует
     */
    public V get(K key) {
        keyValue<K, V> temp = tree.contain(new keyValue<>(key, null));
        if (temp != null) {
            return temp.value;
        } else {
            return null;
        }
    }
}
