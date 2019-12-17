package l2创建我们自己的数组;

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
}
