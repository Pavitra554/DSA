package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.*;

public class ARRAY_LIST {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> l = new ArrayList<Integer>();

        // it will automatically increase the size ...
        // suppose n is the current size then after adding n elements
        // this will increase the size
        // n = n + n/2 + 1
        // if the current size is 10 the n
        // this will increase the size to 16.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // list.add(3,10);
        l.add(1000);
        l.add(2000);
        l.add(3000);
        list.addAll(l);
        list.remove(1);// this will delete index 1
        list.remove(Integer.valueOf(1000));
        // this will delete the index whos value is 1000
        list.set(3, 555);// changing 4 --> 555
        System.out.println(list);

        // we allready know that how to print values using loop
        // but now we are gonna use iterator
        Iterator<Integer> et = list.iterator();
        while (et.hasNext()) {
            System.out.println(et.next());
        }

    }
}
