package l1数组栈的基本实现;

/**
 * 采用数组做底层实现栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 底层内容
     */
    Array<E> array;

    /**
     * 初始化栈,其实就是初始化数组
     * @param capacity 容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取栈的当前元素的个数
     * @return  返回栈的当前元素的个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取栈的总容量
     * @return  返回栈的容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 查看栈是否为空
     * @return  true表示空,false表示不空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入栈
     * @param e 要入栈的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈
     * @return  弹出的栈顶元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶的元素内容,不出栈
     * @return  栈顶元素内容
     */
    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
