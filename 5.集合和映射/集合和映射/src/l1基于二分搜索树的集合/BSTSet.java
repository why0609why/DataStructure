package l1基于二分搜索树的集合;

/**
 * 用二分搜索树来实现集合
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{
    //底层采用二分搜索树
    private BST<E> bst;

    //BSTSet的构造函数是给底层的BST创建一个BST
    public BSTSet(){
        bst = new BST<>();
    }

    //插入的接口就是BST的增添一个数据
    @Override
    public void add(E e) {
        bst.add(e);
    }

    //查询同理
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    //删除更是同理了
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public String toString() {
        return "BSTSet{" +
                "bst=" + bst +
                '}';
    }

    public void print(){
        bst.inOrder();
    }
}
