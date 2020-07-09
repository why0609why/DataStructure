package com.zd.l2字典树的查询;

public class Test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("panda");
        t.add("midoh");

        System.out.println(t.contains("panda"));
        System.out.println(t.contains("tsukasa"));
    }
}
