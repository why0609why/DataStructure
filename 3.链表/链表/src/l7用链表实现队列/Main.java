package l7用链表实现队列;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        linkedListQueue.enqueue(1);

        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(1);
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(666);
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(3);
        System.out.println(linkedListQueue);
    }
}
