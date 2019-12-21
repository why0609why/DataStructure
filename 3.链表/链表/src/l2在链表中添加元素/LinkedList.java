package l2在链表中添加元素;

public class LinkedList<E> {
    /**
     * Node是节点
     */
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表的头节点
     */
    private Node head;
    /**
     * 链表当前的元素的个数
     */
    private int size;

    /**
     * 初始化链表
     *
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 查看链表是否为空
     *
     * @return true为空, flase不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查看链表的当前的元素的个数
     *
     * @return 返回个数
     */
    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        //创建新节点
        Node node = new Node(e);
        //新节点链接头节点
        node.next = head;
        //更新头节点的位置
        head = node;
        //维护size
        size++;
    }

    /**
     * 在链表中索引为index的位置插入元素e
     *
     * @param e     要插入的元素
     * @param index 插入的索引
     */
    public void add(E e, int index) {
        //先判断索引位置是否正确,注意index是可以取到size的,因为index取到size的时候就表明在链表最后插入
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引位置不对");
        }

        //插入的原理是找到index的前一个元素pre,然后把要插入的元素放到index和pre中间
        //而头节点是没有pre的,所以这里当没有虚拟头节点的时候加一个特判
        if (index == 0) {
            addFirst(e);
        } else {
            //寻找pre
            Node pre = null;
            //跳index-1次
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            //找到之后,进行链表的插入
            Node node = new Node(e);
            node.next = pre.next;
            pre.next = node;
            //维护size
            size++;
        }
    }

    /**
     * 在链表尾部插入元素
     * @param e 要插入的元素
     */
    public void addLast(E e) {
        add(e, size);
    }
}
