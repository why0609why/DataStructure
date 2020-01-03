package l1堆的基本结构;

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
}
