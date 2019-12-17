package l1数组基础;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[10];

        int[] b = new int[]{1,2,3,4};
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        for (int i : b) {
            System.out.println(i);
        }
    }
}
