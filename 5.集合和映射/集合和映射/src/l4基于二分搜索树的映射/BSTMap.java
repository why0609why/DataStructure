package l4基于二分搜索树的映射;


/**
 * 用BST实现map
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    /**
     * BST中存储的节点类型
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        /**
         * 构造函数
         *
         * @param key   key
         * @param value value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }


    /**
     * 和BST的插入节点原理一样，都是递归插入节点
     *
     * @param key   key
     * @param value value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 插入的真正的递归函数，递归插入
     *
     * @param cur   在以cur为根节点的BST中插入一个k，v的节点
     * @param key   指定的key
     * @param value 指定的vlaue
     * @return 返回插入节点后的BST
     */
    private Node add(Node cur, K key, V value) {
        //递归到底的情况
        if (cur == null) {
            size++;
            return new Node(key, value);
        }

        //往左或右子树插入
        if (key.compareTo(cur.key) < 0) {
            cur.left = add(cur.left, key, value);
        } else if (key.compareTo(cur.key) > 0) {
            cur.right = add(cur.right, key, value);
        } else {
            //当碰到相等的情况，就更新value
            cur.value = value;
        }

        return cur;
    }


    /**
     * 辅助函数，返回在以cur为根节点的BST中，键为key的节点
     *
     * @param cur cur是节点
     * @param key 指定的key
     * @return 返回key所在的节点
     */
    private Node getNode(Node cur, K key) {
        if (cur == null) {
            return null;
        }

        if (key.compareTo(cur.key) == 0) {
            return cur;
        } else if (key.compareTo(cur.key) < 0) {
            return getNode(cur.left, key);
        } else {
            return getNode(cur.right, key);
        }
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    @Override
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }


    /**
     * 查看整颗BST中是否存在key为指定的key的值
     *
     * @param key 指定的key
     * @return 返回key所在的节点，如果不存在就返回null
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    /**
     * 返回BST中key所对应的value
     *
     * @param key 指定的key
     * @return 返回key所对应的value
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    /**
     * 更新操作，更新BST中指定key所在的节点的value的值为newValue
     *
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("key" +
                    "not exists");
        }

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public void printf() {
        inOrder(root);
    }

    private void inOrder(Node cur) {
        if (cur == null) {
            return;
        }

        inOrder(cur.left);
        System.out.println(cur.key + ":" + cur.value);
        inOrder(cur.right);
    }
}
