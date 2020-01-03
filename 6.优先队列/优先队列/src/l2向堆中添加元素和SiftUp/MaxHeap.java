package l2向堆中添加元素和SiftUp;


public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    /**
     * 返回完全二叉树中索引为index的父节点的索引
     *
     * @param index 要查看父索引的索引
     * @return 返回父节点所在的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("根节点没有父节点");
        }
        return (index - 1) / 2;
    }


    /**
     * 返回完全二叉树中指定索引节点的左孩子所在的索引
     *
     * @param index 指定的索引
     * @return 返回指定的索引的左孩子
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }


    /**
     * 返回完全二叉树中指定索引节点的右孩子所在的索引
     *
     * @param index 指定的索引
     * @return 返回指定的索引的右孩子
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }


    /**
     * 往堆中添加元素，包括给数组末尾添加元素和对末尾元素进行siftup操作
     *
     * @param e 要添加的元素
     */
    public void add(E e) {
        data.addLast(e);
        //对末尾元素进行siftup操作
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作，其实也是维护堆的性质的一个操作，因为往数组末尾添加了元素，堆的性质可能会被
     * 破坏，所以对数组末尾元素进行siftup操作
     *
     * @param k k一开始是数组末尾
     */
    private void siftUp(int k) {
        //循环比较k是否比父节点大，如果大就交换k和父节点的值
        //终止条件是当k是根节点的时候或者k比父节点小的时候
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
}
