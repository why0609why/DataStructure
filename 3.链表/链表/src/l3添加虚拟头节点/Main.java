package l3添加虚拟头节点;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList);
    }
}
