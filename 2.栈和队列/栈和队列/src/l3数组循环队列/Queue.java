package l3数组循环队列;

public interface Queue<E> {
    /**
     * 将元素e入队
     * @param e 要入队的元素
     */
    void enqueue(E e);

    /**
     * 将队首元素出队
     * @return  返回队首元素
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return  返回队首元素
     */
    E getFront();

    /**
     * 查看队列元素个数
     * @return  返回队列中的元素个数
     */
    int getSize();

    /**
     * 查看队列是否为空
     * @return  true表示空,false表示不为空
     */
    boolean isEmpty();
}
