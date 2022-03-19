package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedListSet {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        // This maintain an order according to insertion
        // This will contain only unique element (no duplicate elements).
        set.add(45);
        set.add(4);
        set.add(41);
        set.add(1);
        set.add(12);
        set.add(18);
        set.add(18);
        set.add(18);// this will add 18 only one time
        System.out.println(set);

        set.remove(18);// remove element 18
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set);
    }
}
