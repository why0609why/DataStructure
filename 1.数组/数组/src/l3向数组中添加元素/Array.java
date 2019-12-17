package l3向数组中添加元素;

public class Array {
    /**
     * 用于存放数据的数组
     */
    private int[] data;
    /**
     * size表示数组中元素个数
     */
    private int size;

    /**
     * 初始化数组，并且初始长度是capacity
     * @param capacity 用户设置的初始的数组的容量
     */
    public Array(int capacity) {
        data = new int[capacity];
    }

    /**
     * 不知道初始长度的时候,默认长度是10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 返回数组当前的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return 返回数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return true为空, false不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 给数组末尾添加元素e
     *
     * @param e 要添加的元素
     */
    public void addLast(int e) {
//        //因为写好了add方法,所以添加元素直接调用add就行了
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组长度满了,不能再添加元素了");
//        }
//
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 在数组中索引为index位置上插入元素e
     *
     * @param index 要插入的位置的索引
     * @param e     要插入的元素
     */
    public void add(int index, int e) {
        //判断数组长度是否合法
        if (size == data.length) {
            throw new IllegalArgumentException("数组长度满了,不能再添加元素了");
        }

        //判断插入的索引是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }

        //把从第index的位置上的元素都往后移一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 给数组第一个位置添加一个元素e
     * @param e 要插入的元素
     */
    public void addFirst(int e) {
        add(0, e);
    }
}