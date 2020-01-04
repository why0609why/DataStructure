package com.zd.l2创建线段树;

public class SegmentTree<E> {
    //存放data数组
    private E[] data;
    //线段树数组
    private E[] tree;
    //因为线段树总得有业务逻辑,所以采用接口的实现来实现指定的方法
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        //用户在创建线段树的时候,对应的merger就已经创建好了，也就是线段树的业务逻辑已经想好了
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 创建以treeIndex为根节点的数组区间为l~r的线段树
     *
     * @param treeIndex 线段树根节点
     * @param l         左区间
     * @param r         右区间
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //递归终止条件,如果到了叶子节点直接赋值就行
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        //防溢出
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        //具体业务逻辑
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}