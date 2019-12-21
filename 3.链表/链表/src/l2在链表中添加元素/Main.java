package l2在链表中添加元素;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
    }
}
