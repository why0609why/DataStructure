package l2数组队列的基本实现;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}
