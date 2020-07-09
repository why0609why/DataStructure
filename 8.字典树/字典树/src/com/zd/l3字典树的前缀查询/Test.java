package com.zd.l3字典树的前缀查询;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("panda");
        trie.add("midoh");
        trie.add("tsukasa");

        System.out.println(trie.isPrefix("pa"));
        System.out.println(trie.isPrefix("a"));
    }
}
