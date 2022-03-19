package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.ArrayDeque;

public class ARRAY_DEQUE {
    public static void main(String[] args) {

        ArrayDeque<Integer> adq = new ArrayDeque<Integer>();
        // in this DS you can add and delete an element from start and end both.

        adq.offer(10);// Adding an element (default it goes to end)
        adq.offerFirst(12);// Adding element at start
        adq.offerLast(100);// Adding element at end

        System.out.println(adq);// [12, 10, 100 ]

        System.out.println(adq.peek());// first element by default
        System.out.println(adq.peekFirst());// first element
        System.out.println(adq.peekLast());// last element;

        // adq.poll();// first element by default
        // adq.pollFirst();// first element
        adq.pollLast();// last element;

        System.out.println(adq);
    }
}
