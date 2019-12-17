package l4数组中查询元素和修改元素;

public class Main {
    public static void main(String[] args) {
        Array array = new Array();
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);

        array.add(2,100);
        System.out.println(array);

        System.out.println(array.get(2));
        array.set(2,200);
        System.out.println(array);
    }
}
