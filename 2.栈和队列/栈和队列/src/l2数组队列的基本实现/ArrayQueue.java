package l2数组队列的基本实现;

/**
 * 数组队列,数组头出队,数组尾入队
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    /**
     * 初始化队列
     * @param capacity  队列初始化的容量
     */
    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    /**
     * 将元素e入队
     * @param e 要入对的元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 将队首元素出队,并且返回队首元素
     * @return  返回队首元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素,不出队
     * @return  返回队首元素
     */
    @Override
    public E getFront() {
        return null;
    }

    /**
     * 查看队列当前元素个数
     * @return  列队元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 看队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 返回队列容量
     * @return  队列容量大小
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
