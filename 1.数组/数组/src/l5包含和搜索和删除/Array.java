package l5包含和搜索和删除;

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
     *
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

        //判断插入的索引是否合法,注意这里index可以等于size,因为size虽然没有值,但是可以是一个元素增添的位置
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
     *
     * @param e 要插入的元素
     */
    public void addFirst(int e) {
        add(0, e);
    }


    /**
     * 获取数组中指定索引位置上的元素的
     *
     * @param index 指定索引
     * @return 返回索引位置上的值
     */
    public int get(int index) {
        //判断插入的索引是否合法,注意这里是可以等于size的,因为index是没有值的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }

        return data[index];
    }

    /**
     * 给数组指定索引位置上的值进行更新
     *
     * @param index 索引位置
     * @param e     更新后的值
     */
    public void set(int index, int e) {
        //判断插入的索引是否合法,注意这里是可以等于size的,因为index是没有值的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }

        data[index] = e;
    }

    /**
     * 查看数组中是否包含元素e
     *
     * @param e 要查找的元素e
     * @return 如果包含返回true, 如果不包含就返回false
     */
    public boolean contains(int e) {
        //遍历寻找
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e的位置
     *
     * @param e 要查找的e
     * @return 返回元素e的索引, 如果不存在就返回-1
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中指定索引位置上的值
     *
     * @param index 索引
     * @return 返回删除的值
     */
    public int remove(int index) {
        //判断插入的索引是否合法,注意这里是可以等于size的,因为index是没有值的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }

        int res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        return res;
    }

    /**
     * 删除数组第一个元素
     *
     * @return 返回第一个元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素
     *
     * @return 返回最后一个元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中的所有元素e
     *
     * @param e 要删除的元素e
     */
    public void removeAllElement(int e) {
        //找到e在数组中的位置
        int cur = find(e);
        //只要找到了e,就根据索引删除e
        while (cur != -1) {
            remove(cur);
            cur = find(e);
        }
    }

    /**
     * 自己写一个toString()方法用来打印数组
     *
     * @return 返回包含数组所有内容的字符串
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}