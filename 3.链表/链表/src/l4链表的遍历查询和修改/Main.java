package l4链表的遍历查询和修改;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList);
        linkedList.add(2,666);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(666));
        System.out.println(linkedList.get(2));
        linkedList.set(2, 777);
        System.out.println(linkedList);
    }
}
