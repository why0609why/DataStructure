package l6中序和后序遍历;

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
        root = add(e, root);
    }


    /**
     * 优化后的BST的递归插入
     *
     * @param e   要插入的元素e
     * @param cur cur是当前的节点
     * @return 返回在以cur为根节点的BST插入e后的根节点
     */
    private Node add(E e, Node cur) {
        //递归终止条件
        if (cur == null) {
            size++;
            return new Node(e);
        }

        //e小于当前节点,就往左子树插入
        if (e.compareTo(cur.e) < 0) {
            cur.left = add(e, cur.left);
            //e大于当前节点,就往右子树插入
        } else if (e.compareTo(cur.e) > 0) {
            cur.right = add(e, cur.right);
        }

        return cur;
    }


    /**
     * 查询BST中是否存在元素e
     *
     * @param e 元素e
     * @return true表存在, false不存在
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * 查询是否包含元素的真正递归的函数
     *
     * @param e   元素e
     * @param cur 当前的节点
     * @return true表存在, false不存在
     */
    private boolean contains(E e, Node cur) {
        //如果走到头都没有发现,那就自然就没有元素e了
        if (cur == null) {
            return false;
        }

        //因为是二分搜索树,所以只需要照一条路判断下去就行了
        if (e.equals(cur.e)) {
            return true;
        } else if (e.compareTo(cur.e) < 0) {
            //小的往左子树走
            return contains(e, cur.left);
        } else {
            //大的往右子树走
            return contains(e, cur.right);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树的前序遍历的递归调用
     *
     * @param cur   当前节点
     */
    private void preOrder(Node cur) {
        if (cur == null) {
            return;
        }

        System.out.println(cur.e);
        preOrder(cur.left);
        preOrder(cur.right);
    }


    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二分搜索树的中序遍历的递归调用
     *
     * @param cur   当前节点
     */
    private void inOrder(Node cur) {
        if (cur == null) {
            return;
        }

        inOrder(cur.left);
        System.out.println(cur.e);
        inOrder(cur.right);
    }


    /**
     * 二分搜索树的后序遍历
     */
    public void afterOrder() {
        afterOrder(root);
    }

    /**
     * 二分搜索树的后序遍历的递归调用
     *
     * @param cur   当前节点
     */
    private void afterOrder(Node cur) {
        if (cur == null) {
            return;
        }

        afterOrder(cur.left);
        afterOrder(cur.right);
        System.out.println(cur.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

}