package l3向堆中取出元素和SiftDown;

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


    /**
     * 堆的性质，父节点大于子节点，所以数组中第一个元素就是最大的元素
     *
     * @return 返回堆节点的最大值
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆为空，不能查看最大元素");
        }
        return data.get(0);
    }


    /**
     * 从堆中删除最大的元素
     *
     * @return 返回最大元素
     */
    public E extractMax() {
        E res = findMax();

        //为了简化操作，这里采用把最后一个元素放到根节点这里,因为原来的根节点被删除了
        data.swap(0, data.getSize() - 1);
        //删除数组中最后一个元素
        data.removeLast();

        //因为最后一个元素到了根节点，堆的结构可能会被破坏，所以把这个点下浮下去
        siftDown(0);

        return res;
    }

    /**
     * 下浮操作,比如下浮索引为0这个元素,让0这个元素和他的左孩子右孩子的值大的那个交换，交换后继续交换
     * 知道这个节点比左孩子和右孩子节点的值都大(符合堆的性质)
     *
     * @param k 下浮操作开始的索引
     */
    private void siftDown(int k) {
        //要确保k的左孩子和右孩子都没有越界,因为最下面一层是不用下浮的，所以直接判断他的下一层有没有越界就行
        while (leftChild(k) < data.getSize()) {
            //j是左孩子的索引
            int j = leftChild(k);
            //如果j的右孩子存在并且右孩子的值大于左孩子，就把j更新为右孩子的索引值
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            //如果当前节点的值大于左右孩子的最大值，就退出循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            //正常的就是交换
            data.swap(k, j);
            k = j;
        }
    }
}
