package l4基于二分搜索树的映射;

import l1基于二分搜索树的集合.BST;

public class Test {
    public static void main(String[] args) {
        BSTMap<Integer,Integer> map = new BSTMap<>();

        for (int i = 0; i < 5; i++) {
            map.add(5-i,5-i);
        }
        map.remove(1);
        System.out.println(map.get(2));
        map.set(3,6);
        map.printf();

    }
}
