package com.zd.l1线段树的基本结构;

public class SegmentTree<E> {
    //存放data数组
    private E[] data;
    //线段树数组
    private E[] tree;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[arr.length * 4];
    }


    /**
     * 从data数组中根据索引得到值
     *
     * @param index 指定索引
     * @return 返回data中索引对应的值
     */
    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("索引越界");

        return data[index];
    }

    /**
     * 得到线段树中内容的长度
     *
     * @return 长度
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 或得到指定孩子的左孩子
     *
     * @param index 指定索引
     * @return 返回左孩子的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 或得到指定孩子的右孩子
     *
     * @param index 指定索引
     * @return 返回右孩子的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
