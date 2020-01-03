package l3基于链表的映射;

/**
 * 用链表实现map，感觉这个map更像Hashmap，无序的map
 * @param <K>
 * @param <V>
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    //节点内部类
    private class Node {
        //每个节点存储一个键值对
        public K key;
        public V value;
        //还有下一个节点的指针域
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    //也用到了虚拟头结点
    private Node dummyHead;
    //链表长度
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 添加一个键值对，如果键已经存在就更新这个键的值
     *
     * @param key   添加的键
     * @param value 添加的值
     */
    @Override
    public void add(K key, V value) {
        //查询到链表中是否已经存在key了
        Node node = getNode(key);
        //没有查询到key才进行插入,而且插入到链表头部
        if (node == null) {
            //根据key和value造新节点
            Node s = new Node(key, value);
            //让新节点到链表头部
            s.next = dummyHead.next;
            //让虚拟头结点连接到新节点,插入成功
            dummyHead.next = s;
            size++;
        } else {
            //更新key对应的value
            node.value = value;
        }
    }


    /**
     * 删除链表中key为指定key的节点，如果key存在，删除这个节点并且返回key所对应的value，如果key
     * 不存在就返回null
     *
     * @param key 指定的key
     * @return 返回value或者null
     */
    @Override
    public V remove(K key) {
        //链表中删除节点的逻辑其实是找到要删除的链表的前驱,然后根据让前驱指向下一个的下一个就删除了指定节点
        Node prev = dummyHead;
        while (prev.next != null) {
            //找到要删除的前驱
            if (prev.next.key.equals(key)) {
                break;
            }

            prev = prev.next;
        }

        //找到前驱后让前驱指向下一个的下一个
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }

        return null;
    }

    /**
     * 查看map中是否包含k
     *
     * @param key 要查询的k
     * @return 返回用链表实现的map中是否存在k
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * map的根据键获取值，如果键不存在就返回null
     *
     * @param key 指定的key
     * @return 返回key对应的值
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }


    /**
     * set操作，如果key不存在就报错，如果key存在就更新key所对应的值
     *
     * @param key      指定的key
     * @param newValue 新值
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("键不存在");
        } else {
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 辅助函数,获得链表中k对应的节点
     *
     * @param key 指定的k
     * @return 返回链表中节点k和传入的k相等的节点
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;

        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur!=null){
            sb.append(cur.key+":"+cur.value+",");
            cur = cur.next;
        }
        return sb.toString();
    }
}
