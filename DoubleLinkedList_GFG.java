package DATA_STRUCTURE;

public class DoubleLinkedList_GFG {
    static class Node{
        int data;
        Node pre;
        Node next;

        public Node(int d) {
            data = d;
        }
    }
    //creating two linking part
    Node head,tail = null;
    public void add(int d){ //adding nodes
        Node new_node = new Node(d);
        if(head == null){
            head = tail = new_node;
            head.pre = null;
            tail.next = null;
        }
        else{
            tail.next = new_node;
            new_node.pre = tail;
            tail = new_node;
            tail.next = null;

        }
    }
    //displaying forward
    public void display_forward(){
        Node n = head;
        while(n!=null){
            System.out.print("  "+n.data);
            n = n.next;
        }
    }

    //displaying backward
    public void display_backward(){
        Node n = tail;
        while(n!=null){
            System.out.print(n.data+"  ");
            n = n.pre;
        }
    }

    //counting Nodes

    public int count(){
        Node n = head;
        int p = 0;
        while(n!=null){
            p++;
            n = n.next;
        }
        System.out.println("Total number of Nodes is "+p);
        return p;
    }

    //searching ing Dll

    public void search(int e){
        Node n = head;
        int p = 0;
        while(n!=null){
            p++;
            if(n.data == e){
                System.out.println(e+" is in NODE "+p);
                return;
            }
            n = n.next;
        }
        System.out.println("Element not found");
    }

    //Inserting a Node in front

    public void Insert_start(int d){
        Node n =  new Node(d);
        if (head == null){
            head = tail = n;
        }
        else{
            n.next = head;
            head.pre = n;
            head = n;
        }
    }

    //Inserting a Node at end

    public void Insert_end(int d){
        Node n = new Node(d);

        if(head == null){
            head = tail = n;
        }
        else{
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
    }

    //Inserting a Node anywhere

    public void Insert_anywhere(int d,int p){
        Node n = new Node(d);
        Node current = head;
        Node previous = null;
        int pos = 0;

        if(head == null){
            Insert_start(d);
        }
        else if(p == count()+1){
            Insert_end(d);
        }
        else{
            while(pos<p){
                previous = current;
                current = current.next;
                if (current.next == null){
                    break;
                }
                pos++;
            }
            previous.next = n;
            n.pre = previous;
            n.next = current;
            current.pre = n;
        }
    }

    //delete from start

    public void Delete_start(){
        if(head == null){
            System.out.println("Underflow");
            return;
        }
        if(head.next == null){
            head = tail = null;
        }
        else{
            head = head.next;
            head.pre = null;
        }
    }

    //Delete from end

    public  void Delete_end(){
        if(head == null){
            System.out.println("Underflow");
            return;
        }
        if(head.next == null){
            head = tail = null;
        }
        else{
            tail = tail.pre;
            tail.next = null;
        }
    }

    //Delete anywhere

    public void Delete_Anywhere(int p){
        int i = 0;
        Node current = head;
        Node previous = null;
        if(current==null){
            System.out.println("Underflow");
            return;
        }
        if(head.next == null){
            Delete_start();
        }
        else if(p == count()){
            Delete_end();
        }
        else{
            while(i<p){
                previous = current;
                current = current.next;
                if(current == null){
                    break;
                }
                i++;
            }
            previous.next = current.next;
            current.next.pre = previous;
        }
    }



    public static void main(String[] args) {
        DoubleLinkedList_GFG dll = new DoubleLinkedList_GFG();

        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        dll.add(7);
        dll.add(8);

        dll.Insert_start(0);
        dll.Insert_end(9);
        dll.Insert_anywhere(100,5);

//        dll.Delete_start();
//        dll.Delete_end();
        dll.Delete_Anywhere(5);

        dll.display_forward();
        System.out.println("\n\n");
        dll.display_backward();
//        System.out.println("\n");
//        dll.count();

//        System.out.println("\n");

//        dll.search(4);
    }
}
