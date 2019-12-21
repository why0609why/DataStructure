package l10删除二分搜索树的任意值;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);

        System.out.println("********");
        bst.levelOrder();
        System.out.println("********");
        bst.remove(5);
        bst.levelOrder();
        System.out.println(bst.getSize());
        System.out.println("********");
    }
}