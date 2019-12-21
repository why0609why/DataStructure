package l6中序和后序遍历;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);

        bst.preOrder();
        System.out.println("-----------");
        bst.inOrder();
        System.out.println("-----------");
        bst.afterOrder();
    }
}
