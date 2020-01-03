package l3基于链表的映射;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedListMap<>();

        for (int i = 0; i < 5; i++) {
            map.add(i,i);
        }

        map.add(4,10);
        map.remove(4);
        map.set(3,10);
        System.out.println(map.getSize());
        System.out.println(map);
    }
}
