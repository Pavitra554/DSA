package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PRIORITY_QUEUE {
    public static void main(String[] args) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        minPQ.offer(85);
        minPQ.offer(5);
        minPQ.offer(8);
        minPQ.offer(10);

        // minimum element come first
        System.out.println(minPQ);// [5, 10, 8, 85]
        minPQ.poll();
        // minimum element has deleted
        // and now again minimum element from the remaining elements will come on first
        System.out.println(minPQ);// [8, 10, 85]
        System.out.println(minPQ.peek());// this will return which element is in first

        // The above priority queue was min priority queue
        // we can also create a max priority queue
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        maxPQ.offer(85);
        maxPQ.offer(5);
        maxPQ.offer(8);
        maxPQ.offer(10);

        // max element come first
        System.out.println(maxPQ);// [85, 10, 8, 5]
        maxPQ.poll();
        // max element has deleted
        // and now again maximum element from the remaining elements will come on first
        System.out.println(maxPQ);// [10, 5, 8]
        System.out.println(maxPQ.peek());// this will return which element is in first

    }
}
