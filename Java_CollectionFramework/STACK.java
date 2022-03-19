package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.Stack;

public class STACK {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(1);// Adding elements
        s.push(2);// Adding elements
        s.push(3);// Adding elements
        s.push(4);// Adding elements
        System.out.println(s.capacity());// checking size of stack
        System.out.println(s);
        System.out.println(s.peek());// checking first element (LIFO -> last in first out)
        s.pop();// Removing element
        s.pop();

        System.out.println(s);
    }
}
