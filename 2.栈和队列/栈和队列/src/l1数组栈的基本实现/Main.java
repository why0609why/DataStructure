package l1数组栈的基本实现;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        System.out.println(arrayStack.getCapacity());
        System.out.println(arrayStack.getSize());
    }
}
