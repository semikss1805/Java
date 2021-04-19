package Lab6.test;

import Lab6.model.Wood;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        Random rnd = new Random();
        Collection<Integer> c1 = new ArrayList<>();
        Collection<Integer> c2 = new LinkedHashSet<>();
        Collection<Integer> c3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c1.add(rnd.nextInt(10));
            c2.add((rnd.nextInt(10)));
        }
        c2.addAll(c1);
        c3.removeAll(c2);
        System.out.println(c1 + " removeAll " + c2 + " = " + c3);

        c3.clear();
        c3.addAll(c2);
        c3.removeAll(c1);
        System.out.println(c2 + " removeAll " + c1 + " = " + c3);

        c3.clear();
        c3.addAll(c1);
        c3.retainAll(c2);
        System.out.println(c1 + " retainAll " + c2 + " = " + c3);

        c3.clear();
        c3.addAll(c2);
        c3.retainAll(c1);
        System.out.println(c2 + " retainAll " + c1 + " = " + c3);

        Collection<Integer> c4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c4.add(rnd.nextInt(10));
        }
        System.out.println(c4);
        //???
        System.out.println(c4);

        Collection<Integer> coll = new ArrayDeque<>();
        Collections.addAll(coll, 1, 3, 5, 3, 4, 2, 14);
        Collections.addAll(coll, new Integer[]{3,7,12});
        System.out.print("\n\n" + coll);
        System.out.println(Collections.frequency(coll,3));
        System.out.println(Collections.max(coll));
        System.out.println(Collections.min(coll));

        List<Integer> list = new ArrayList<>(coll);
        Collections.swap(list, 2, 6);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 3));
        Collections.sort(list, (a, b) -> a - b);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 3, (a, b) -> b - a));
        Collections.reverse(list);
        System.out.println(list);
        Collections.rotate(list,2);//??
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.replaceAll(list, 3, 8);
        System.out.println(list);
        Collections.fill(list, 0);
        System.out.println(list);

        System.out.print("\n\n");
        Set<Wood> set = new HashSet<>();
        set.add(new Wood(1, "Lypa", 1f));
        set.add(new Wood(1, "Lypa", 1f));
        set.add(new Wood(1, "Lypa", 1f));

        Wood a = new Wood(1, "Lypa", 1f);
        Wood b = new Wood(1, "Lypa", 1f);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() + " " + b.hashCode());
        set.forEach(System.out::println);
    }
}
