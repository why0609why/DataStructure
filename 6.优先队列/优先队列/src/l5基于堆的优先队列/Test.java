package l5基于堆的优先队列;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < 100; i++) {
            priorityQueue.enqueue(i);
        }

        System.out.println(priorityQueue.getFront());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.getFront());
    }
}
