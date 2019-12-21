package l7用链表实现队列;

/**
 * 使用链表实现队列,采用头指针尾指针来操作链表实现队列
 *  tail处入队,head出出队
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 内部节点
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

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * head是头指针,tail是尾指针
     * 并且出队是在head处出队的,tail进行的是入队,因为末尾入队是O(1)操作
     */
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列链表入队操作
     *
     * @param e 要入队的元素
     */
    @Override
    public void enqueue(E e) {
        //如果队列为空,那么tail就应该直接连接新节点,并且增添后只有一个节点,head和tail都是指向一个节点的
        if (isEmpty()) {
            tail = new Node(e);
            head = tail;
            //如果队列不为空,直接tail后添加节点就算入队了
        } else {
            tail.next = new Node(e);
            //更新tail的位置
            tail = tail.next;
        }

        size++;
    }

    /**
     * 出队操作
     * @return  返回队首节点的值
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,不能出队");
        }

        //注意出队是在链表头出队的,其实也就是删除头节点,也就是删除head节点,再更新head指针
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 查看队首元素
     * @return  返回队首元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,不能查看");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
