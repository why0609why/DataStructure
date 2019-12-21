package l9删除二分搜索树的最小值和最大值;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);

        bst.removeMin();
        bst.levelOrder();
        System.out.println("********");
        bst.removeMax();
        bst.levelOrder();
        System.out.println("********");
        bst.removeMax();
        bst.levelOrder();
    }
}
