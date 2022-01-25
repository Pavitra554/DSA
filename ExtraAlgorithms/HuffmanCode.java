package DATA_STRUCTURE.ExtraAlgorithms;
import java.util.*;
//Huffman Code
//Time Complexity - O(n logn)
class Node{
    int data;
    char c;

    Node left;
    Node right;
}

class MyComparator implements Comparator<Node>{
    public int compare(Node x,Node y){
        return x.data - y.data;
    }
}

public class HuffmanCode {

    static void printCode(Node root,String str){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c+" : "+str);
            return;
        }
        printCode(root.left, str + "0");

        printCode(root.right, str + "1");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of character : ");
        int n = s.nextInt();

        char chrs[] = new char[n];
        int frq[] = new int[n];

        for (int i = 0; i < n ; i++) {
            System.out.println("Enter the character and frequency : ");
            chrs[i] = s.next().charAt(0);
            frq[i] = s.nextInt();
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>(n,new MyComparator());

        for (int i = 0; i < n; i++) {
            Node sum = new Node();
            sum.c = chrs[i];
            sum.data = frq[i];

            sum.left = null;
            sum.right = null;

            q.add(sum);
        }

        Node root = null;

        while(q.size()>1){
            Node x = q.peek();
            q.poll();

            Node y = q.peek();
            q.poll();

            Node r = new Node();
            r.data = x.data + y.data;
            r.c = '-';

            r.left = x;
            r.right = y;

            
            q.add(r);
            root = r;
        }
        printCode(root, "");

        s.close();

    }
}
