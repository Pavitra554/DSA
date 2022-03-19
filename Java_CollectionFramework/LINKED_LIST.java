package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.LinkedList;

public class LINKED_LIST {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(2);// Adding element
        list.add(19);
        list.addFirst(1);// Adding element at first
        list.addLast(20);// Adding element at last
        list.remove(Integer.valueOf(20));// this will delete index having value 20

        System.out.println(list);

    }
}
