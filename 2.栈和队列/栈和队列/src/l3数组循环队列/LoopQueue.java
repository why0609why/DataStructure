package l3数组循环队列;

public class LoopQueue<E> implements Queue<E> {
    /**
     * 这里不使用以前的数组,只用一个简单的数组
     */
    private E[] data;
    /**
     * front是头指针,tail是尾指针
     */
    private int front, tail;
    /**
     * size是队列中当前的元素个数
     */
    private int size;  // 有兴趣的同学，在完成这一章后，可以思考一下：
    // LoopQueue中不声明size，如何完成所有的逻辑？
    // 这个问题可能会比大家想象的要难一点点：）

    /**
     * 初始化一个指定容量的循环队列
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 初始化一个默认的容量的循环队列
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取循环队列的容量
     * @return  循环队列的容量
     */
    public int getCapacity() {
        //注意容量和数组长度的关系,因为循环队列的头尾指针的关系,故意浪费一个容量空间
        //循环队列的具体容量是数组长度减1
        return data.length - 1;
    }

    /**
     * 查看循环队列是否为空
     * @return  true为空,false不为空
     */
    @Override
    public boolean isEmpty() {
        //因为采用front和tail进行标记队列首和队列尾
        return front == tail;
    }

    /**
     * 返回循环队列的元素个数
     * @return  元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 入队元素
     * @param e 要入队的元素
     */
    @Override
    public void enqueue(E e) {
        //注意这里tail的变化用到的是data.length,因为变化是要取余的,那么对谁取余一定是要明白的
        //肯定不是对循环队列的容量取余的,想想自然能发现一定是对数组长度取余的
        //这是判断满的情况
        if ((tail + 1) % data.length == front)
            //若队列为满,就扩容成原来的两倍
            resize(getCapacity() * 2);

        //tail是入队的时候的索引
        data[tail] = e;
        //tail变化
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 将队首元素进行出队
     * @return  返回队首元素
     */
    @Override
    public E dequeue() {
        //当循环队列为空的时候,不能出队
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        //先保留队首元素
        E ret = data[front];
        //后移front
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            //缩容成原来的二分之一
            resize(getCapacity() / 2);
        return ret;
    }

    /**
     * 获取队首元素,不出队
     * @return  返回队首元素
     */
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        //front指向队首
        return data[front];
    }

    /**
     * 扩容、缩容调用的方法
     * @param newCapacity   新队列的长度
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        //赋值,注意到是把原数组中的front到tail的值复制到新数组的0~size
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        //因为新的空间比原来大,而且一定是能存放下原来的内容的,所以直接就从0开始存放元素了
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
