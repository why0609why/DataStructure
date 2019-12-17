package l3数组循环队列;

public class Main {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.enqueue(1);
        System.out.println(loopQueue);
        loopQueue.enqueue(1);
        System.out.println(loopQueue);
        loopQueue.enqueue(1);
        System.out.println(loopQueue);
        loopQueue.enqueue(1);
        System.out.println(loopQueue);
    }
}
