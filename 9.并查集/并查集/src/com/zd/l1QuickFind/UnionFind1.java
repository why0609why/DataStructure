package com.zd.l1QuickFind;

public class UnionFind1 implements UF {
    /**
     * 用于存放数组中对应索引位置上的元素对应的集合
     */
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        //初始每个元素的所属的集合都是自己
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    /**
     * 查询索引为p对应的元素的集合是什么
     *
     * @param p 数组索引
     * @return 返回数组中索引上的元素的所属的集合
     */
    private int find(int p) {
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
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
        int pID = find(p);
        int qID = find(q);

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }
}
