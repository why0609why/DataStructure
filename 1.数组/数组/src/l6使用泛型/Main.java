package l6使用泛型;

public class Main {
    public static void main(String[] args) throws Exception{

        Array<Student> array1 = new Array<>();
        array1.addFirst(new Student("zs","zs"));
        array1.addFirst(new Student("lisi","lisi"));
        System.out.println(array1);

        array1.removeAllElement(new Student("zs","zs"));
        System.out.println(array1);
    }
}
