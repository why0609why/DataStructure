package l3向堆中取出元素和SiftDown;

public class Test {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < 20; i++) {
            maxHeap.add(i);
        }

        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());

        System.out.println(maxHeap.findMax());
    }
}
