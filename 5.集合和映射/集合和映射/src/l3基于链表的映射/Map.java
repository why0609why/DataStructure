package l3基于链表的映射;

/**
 * map的基本接口
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
