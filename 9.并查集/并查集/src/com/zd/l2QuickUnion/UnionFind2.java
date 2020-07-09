package com.zd.l2QuickUnion;

public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    /**
     * 查询并查集中元素的个数
     *
     * @return 返回元素的个数
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 找出p对应的集合(其实就是p的老大)
     * 复杂度O(h),h最大为和p同集合的元素个数
     *
     * @param p 对应的索引
     * @return 返回p的最根的节点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p的索引不对");

        while (p != parent[p])
            p = parent[p];

        return parent[p];
    }


    /**
     * 查询数组中索引为p上的元素和索引为q的元素是否是同一集合(是否连通)
     *
     * @param p 索引
     * @param q 索引
     * @return true表连通，false表不连通
     */
    @Override
    public boolean isConnected(int p, int q) {
        if (p < 0 || p >= parent.length || q < 0 || q >= parent.length)
            throw new IllegalArgumentException("q或者q的索引不对");

        return find(p) == find(q);
    }


    /**
     * 连通两个元素
     *
     * @param p 索引p
     * @param q 索引q
     */
    @Override
    public void unionElements(int p, int q) {
        if (p < 0 || p >= parent.length || q < 0 || q >= parent.length)
            throw new IllegalArgumentException("q或者q的索引不对");

        int pRoot = find(p);
        int qRoot = find(q);

        //因为寻找父元素的时候会一直寻找父元素，所以这里只需要让一个
        //根指向另一个根就行了
        parent[pRoot] = qRoot;
    }
}
