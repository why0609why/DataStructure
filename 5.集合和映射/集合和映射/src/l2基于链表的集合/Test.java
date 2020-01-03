package l2基于链表的集合;

public class Test {
    public static void main(String[] args) {
        LinkedListSet linkedListSet = new LinkedListSet();
        for (int i = 0; i < 10; i++) {
            linkedListSet.add(i);
        }
        linkedListSet.add(1);
        System.out.println(linkedListSet);
    }
}
