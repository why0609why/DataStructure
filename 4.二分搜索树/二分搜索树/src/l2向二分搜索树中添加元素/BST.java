package l2向二分搜索树中添加元素;

/**
 * 二分搜索树的节点必须都是可比较性的
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    /**
     * 内部节点
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * 初始化二分搜索树
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获得二叉树当前元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
     *
     * @return true为空, false不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向BST中插入一个节点
     *
     * @param e 要插入的元素
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            add(e, root);
        }
    }

    /**
     * 往BST中插入节点的真正的递归操作
     * @param e 插入的元素
     * @param cur   当前节点
     */
    private void add(E e, Node cur) {
        //递归终止条件
        if (e.equals(cur.e)) {
            return;
        } else if (e.compareTo(cur.e) < 0 && cur.left == null) {
            cur.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(cur.e) > 0 && cur.right == null) {
            cur.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(cur.e) < 0) {
            add(e, cur.left);
        } else {
            add(e, cur.right);
        }
    }

}