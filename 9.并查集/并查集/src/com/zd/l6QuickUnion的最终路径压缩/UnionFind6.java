package com.zd.l6QuickUnion的最终路径压缩;

public class UnionFind6 implements UF {
    private int[] parent;
    //记录每个老大的团体的元素的个数
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (p != parent[p]) {
            //路径压缩，让p指向老大
            parent[p] = find(parent[p]);
        }

        //最后返回根节点
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
        //让深度小的树指向深度大的数，这样新树深度就有可能小一点
        if (rank[pRoot] < rank[qRoot]) {
            //深度小的树指向深度大的树，因为rank记录的是深度
            //所以当一棵树比另一棵树的深度大的时候高度是不用更新的
            //假设h1和h2，那么min(h1) = h2+1，所以就算让h2指向h1的根节点
            //h1的高度也不用更新
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            //但是当两棵树高度相同的时候，就得注意让被指向的树的高度加1
            //因为多了一层根节点
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
