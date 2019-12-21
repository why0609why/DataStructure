package l3改进插入操作;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(4);
        bst.add(3);
        bst.add(6);

        System.out.println(bst);
    }
}
