package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_LL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);// Adding element
        q.offer(2);// Adding element
        q.offer(3);// Adding element
        q.offer(4);// Adding element
        q.offer(5);// Adding element
        System.out.println(q);
        System.out.println(q.peek());// checking frist element that has to be dequeue
        q.poll();// dequeueing first element (FIFO -> first in first out)
        System.out.println(q);
    }
}
