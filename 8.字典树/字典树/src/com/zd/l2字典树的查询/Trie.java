package com.zd.l2字典树的查询;

import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean flag) {
            this.isWord = flag;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    //字典树的根节点
    private Node root;
    //存储了多少个单词
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 在以根为root的字典树中插入一个字符串
     *
     * @param word word为要插入的字符串
     */
    public void add(String word) {
        //从字典树根节点开始遍历
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //查看当前节点下面是否有c字符
            if (!cur.next.containsKey(c)) {
                //如果没有就拼接上c
                cur.next.put(c, new Node());
            }
            //更新cur的位置
            cur = cur.next.get(c);
        }

        //走到字符串的最后一个节点，把最后一个节点的isWord设置为true
        //表示到这里是一个字符串
        if (!cur.isWord) {
            size++;
            cur.isWord = true;
        }
    }

    /**
     * 检查字典树中是否存在指定字符串
     *
     * @param str 要查询的字符串
     * @return 返回是否存在
     */
    public boolean contains(String str) {
        //和插入的逻辑差不多，也是从根节点开始寻找
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //如果当前节点下面没有找到c，说明就没有这个字符串
            if (!cur.next.containsKey(c))
                return false;

            cur = cur.next.get(c);
        }
        //找到字符串的最后一个节点，可能这个节点是另一个字符串的前缀，所以要看到这个节点是不是一个字符串
        return cur.isWord;
    }
}
