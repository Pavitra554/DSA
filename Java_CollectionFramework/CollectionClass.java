package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionClass {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        l.add(45);
        l.add(1);
        l.add(99);
        l.add(2);
        l.add(210);
        l.add(21);
        l.add(1);
        l.add(1);

        // this will print the minimum element in list
        System.out.println(Collections.min(l));
        // this will print the maximum element in list
        System.out.println(Collections.max(l));

        // this will print the occurrence of a element in the list
        System.out.println(Collections.frequency(l, 1));

        Collections.sort(l);
        System.out.println(l);// this wiill print whole list in increasing order
        Collections.sort(l, Comparator.reverseOrder());
        System.out.println(l);// this wiill print whole list in decreasing order

        // If we want to sort objects.
        // Then we have to make that class compareable by implementing
        // that class by Comparator<OBJECT_NAME>.
        // Then we have to override the method compareTo method
    }
}
