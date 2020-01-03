package l2向堆中添加元素和SiftUp;

public class Array<E> {
    /**
     * 用于存放数据的数组
     */
    private E[] data;
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
        data = (E[]) new Object[capacity];
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
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
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
    public void addLast(E e) {
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
    public void add(int index, E e) {
        //判断插入的索引是否合法,注意这里index可以等于size,因为size虽然没有值,但是可以是一个元素增添的位置
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }
        //判断数组长度是否合法
        if (size == data.length) {
            resize(2 * size);
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
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 获取数组中指定索引位置上的元素的
     *
     * @param index 指定索引
     * @return 返回索引位置上的值
     */
    public E get(int index) {
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
    public void set(int index, E e) {
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
    public boolean contains(E e) {
        //遍历寻找
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
    public E remove(int index) {
        //判断插入的索引是否合法,注意这里是可以等于size的,因为index是没有值的
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("插入的索引位置不合法");
        }
        if (size <= data.length / 4 && data.length / 4 != 0) {
            resize(data.length / 2);
        }

        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return res;
    }

    /**
     * 删除数组第一个元素
     *
     * @return 返回第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素
     *
     * @return 返回最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中的所有元素e
     *
     * @param e 要删除的元素e
     */
    public void removeAllElement(E e) {
        //找到e在数组中的位置
        int cur = find(e);
        //只要找到了e,就根据索引删除e
        while (cur != -1) {
            remove(cur);
            cur = find(e);
        }
    }


    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    /**
     * 交换索引i，j位置上的值
     *
     * @param i 索引
     * @param j 索引
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("i或者j的索引不对");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
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