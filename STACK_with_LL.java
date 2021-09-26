package DATA_STRUCTURE;
import static java.lang.System.exit;
public class STACK_with_LL {
    class Node {
        int data;
        Node next;
    }
    Node top;

    STACK_with_LL(){
        this.top = null;
    }

    public void push(int d){//adding elements
        Node n  = new Node();
        n.data = d;
        n.next = top;
        top = n;
    }

    public boolean isEmpty(){//checking is empty or not
        return top == null;
    }

    public int peek(){
        if(top == null){
            return top.data;
        }
        else{
            System.out.println("Empty");
            return -1;
        }
    }

    public void pop(){//Removing
        if(top == null){
            System.out.println("Under flow");
            return;
        }
        else{
            top = top.next;
        }
    }

    public void display(){//displaying
        if(top ==null){
            System.out.println("Underflow");
            exit(1);
        }
        else{
            Node temp = top;
            while(temp!=null){
                System.out.print(temp.data+"-->");
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        STACK_with_LL s = new STACK_with_LL();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);

        s.display();

        s.pop();
        s.pop();
        s.pop();
        System.out.println("\n\n");
        s.display();
    }
}
