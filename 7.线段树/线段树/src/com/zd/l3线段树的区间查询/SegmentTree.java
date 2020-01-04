package com.zd.l3线段树的区间查询;


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


    /**
     * 返回l~r区间的merger操作的值
     *
     * @param queryL 左区间
     * @param queryR 右区间
     * @return 返回区间merger值
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("区间l或者区间r位置不正确");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }


    /**
     * 在线段树索引为treeIndex的节点中l~r(其实是一个节点的对应区间)查询queryL到queryR的值
     *
     * @param treeIndex 指定的索引
     * @param l         节点对应的左区间
     * @param r         节点对应的右区间
     * @param queryL    要查询的左区间
     * @param queryR    要查询的右区间
     * @return 返回指定区间的merger值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //递归终止条件,如果当前区间就是要查询的左右区间,直接返回tree[treeIndex]就行了，因为这里面存放了
        //这个区间的merger操作的结果
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //如果要查询的区间在mid的右半边
        if (queryL >= mid + 1) {
            //那就去右区间去查
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            //如果要查询的区间在mid的左半边
        } else if (queryR <= mid) {
            //就去左半边查找
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        //否则就是mid把要查询的区间分成了两部分,那就是把要查询的区间分成两个部分,然后都去查询一下,递归查询
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merger(leftResult, rightResult);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("索引位置不正确");
        }

        set(0, 0, data.length - 1, index, e);
    }


    /**
     * 单点更新
     *
     * @param treeIndex 从treeIndex开始
     * @param l         当前treeIndex对应的左区间
     * @param r         当前treeIndex对应的右区间
     * @param index     data中指定的索引
     * @param e         更新的新值e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        //递归终止条件,递归到指定节点
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        //找mid
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //如果要更新的索引在当前区间的右区间
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
            //如果在左区间
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }

        //如果子节点发生了改变,那么这个节点也要重新merger一下
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}