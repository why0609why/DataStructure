package l1二叉树基础;

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
     * @return  true为空,false不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
