package com.zd.l3QuickUnion的size优化;

public interface UF {
    /**
     * 查询并查集中元素的个数
     *
     * @return 返回元素的个数
     */
    int getSize();

    /**
     * 查看数组中索引p，q上的元素是否是一个集合中
     *
     * @param p 索引
     * @param q 索引
     * @return true表示是同一个集合，false表示不是
     */
    boolean isConnected(int p, int q);

    /**
     * 使数组中索引为p，q的元素成为同一个集合
     *
     * @param p 索引p
     * @param q 索引q
     */
    void unionElements(int p, int q);
}
