package com.zd.l2创建线段树;

public class Test {
    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer(i);
        }
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(a, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segmentTree);
    }
}
