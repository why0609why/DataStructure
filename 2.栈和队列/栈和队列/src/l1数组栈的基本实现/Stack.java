package l1数组栈的基本实现;

public interface Stack<E> {
    /**
     * 获取栈中的元素的个数
     * @return 返回个数
     */
    int getSize();

    /**
     * 看栈是否为空
     * @return true表示空,false表示非空
     */
    boolean isEmpty();

    /**
     * 将元素e入栈
     * @param e 要入栈的元素
     */
    void push(E e);

    /**
     * 弹出栈顶元素
     * @return  从栈中弹出栈顶元素,并且作为该方法的返回值
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return  返回栈顶元素的值
     */
    E peek();
}
