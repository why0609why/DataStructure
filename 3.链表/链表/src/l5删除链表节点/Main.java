package l5删除链表节点;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList);
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
