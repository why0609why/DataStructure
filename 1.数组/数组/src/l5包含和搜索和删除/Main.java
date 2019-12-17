package l5包含和搜索和删除;

public class Main {
    public static void main(String[] args) {
        Array array = new Array();
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addLast(10);
        array.addLast(5);
        System.out.println(array);
        array.removeAllElement(1);
        array.removeLast();
        System.out.println(array);
    }
}
