package l4链表的遍历查询和修改;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    /**
     * 链表中元素的个数
     */
    private int size;

    /**
     * 初始化链表
     * dummyhead为一个节点
     * size为空
     */
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return true空, false不空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index 指定的索引
     * @param e     要插入的元素e
     */
    public void add(int index, E e) {
        //判断索引
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        //找到index的前驱
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        //prev.next = new Node(e, prev.next);
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e 要插入的元素e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e 要插入的元素e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表中指定索引位置上的值
     *
     * @param index 指定索引
     * @return 返回索引上的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获得链表头部元素
     *
     * @return 返回第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改链表指定索引上的值
     *
     * @param index 指定索引
     * @param e     值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 查看链表中是否含有元素e
     * @param e 要查找的元素e
     * @return  true表存在,false表不存在
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}