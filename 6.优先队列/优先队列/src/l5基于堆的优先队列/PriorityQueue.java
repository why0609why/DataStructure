package l5基于堆的优先队列;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    /**
     * 采用最大堆作为优先队列的底层
     */
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    /**
     * 看队列是否为空
     *
     * @return true，false
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }


    /**
     * 入队
     *
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }


    /**
     * 优先队列出队
     *
     * @return 返回优先队列队首元素
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }


    /**
     * 查看优先队列的队首元素
     *
     * @return 返回队首元素
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
