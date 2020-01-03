package l1基于二分搜索树的集合;

public class Main {
    public static void main(String[] args) {
        BSTSet<Integer> bstSet = new BSTSet<>();

        for (int i = 0; i < 10; i++) {
            bstSet.add(i);
        }

        bstSet.add(9);
        bstSet.add(9);
        bstSet.add(9);
        bstSet.add(9);
        bstSet.add(9);

        bstSet.remove(3);
        bstSet.remove(2);
        bstSet.print();
    }
}
