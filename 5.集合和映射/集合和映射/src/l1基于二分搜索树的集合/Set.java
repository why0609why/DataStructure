package l1基于二分搜索树的集合;


/**
 * 集合接口方法
 * @param <E>
 */
public interface Set<E> {


    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
