package l7动态数组;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();

        array.addFirst(1);
        System.out.println(array);
        array.addFirst(2);
        System.out.println(array);
        array.addFirst(3);
        System.out.println(array);
        array.addFirst(4);
        System.out.println(array);
        array.addFirst(5);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.addFirst(6);
        System.out.println(array);
        array.addFirst(7);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
    }
}
