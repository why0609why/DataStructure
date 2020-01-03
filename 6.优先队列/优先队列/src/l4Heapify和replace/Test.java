package l4Heapify和replace;

public class Test {
    public static void main(String[] args) {
        Integer[] data = new Integer[20];

        for (int i = 0; i < 20; i++) {
            data[i] = new Integer(i);
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>(data);

        System.out.println(maxHeap.findMax());
        System.out.println(maxHeap.extractMax());
        maxHeap.add(20);
        System.out.println(maxHeap.findMax());
        maxHeap.extractMax();
        System.out.println(maxHeap.findMax());
    }
}
