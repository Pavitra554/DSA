package DATA_STRUCTURE;

public class CircularLinkedList_GFG {
    //Creating  node
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }
    public Node head = null;
    public Node tail = null;

    //adding elements in Node (from ending)

    public void add(int d){
        Node n = new Node(d);
        if(head  == null){
            head = n;
            tail = n;
            n.next = head;
        }
        else{
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    //counting NODES

    public int count(){
        Node current = head;
        int p = 0;
       if(head == null){
           System.out.println("List is empty");
           return 0;
       }
       else{
           do{
               p++;
               current = current.next;
           }while (current.next!=head);
       }
        System.out.println("Total number of Nodes : "+p);
        return p;
    }

    //Searching a particular element

    public int search(int e){
        Node n = head;
        int p = 0;
        do{
            p++;
            if(n.data == e){
                System.out.println(e+" is in Node "+p);
                return p;
            }
            n = n.next;

        }while(n!=head);
        System.out.println("Element not found");
        return -1;
    }

    //Inserting NODE at start

    public void insert_start(int d){
        Node new_Node = new Node(d);
       if(head ==  null){
           head = tail = new_Node;
       }
       else{
           new_Node.next = head;
           tail.next = new_Node;
           head = new_Node;
       }
    }

    //Inserting NODE at end

    public void instert_end(int d){
        Node new_node = new Node(d);
        if (head == null){
            head =tail = new_node;
        }
        else{
            tail.next = new_node;
            new_node.next = head;
            tail = new_node;
        }
    }

    //Inserting NODE at anywhere

    public void insert_anywhere(int d,int p){
        Node new_Node = new Node(d);
        new_Node.next = null;
        if(this.head == null){
            if(p!=0){
                return;
            }
            else{
                this.head = new_Node;
            }
        }
        if(head!=null && p ==0){
            insert_start(d);
            return;
        }
        Node current_node = this.head;
        Node pre = null;
        int i = 1;
        while(i<p){
            pre = current_node;
            current_node = current_node.next;
            if(current_node ==null){
                break;
            }
            i++;
        }
        new_Node.next = current_node;
        pre.next = new_Node;
    }

    //Deleting Node from start

    public void Delete_start(){
        if(head == null){
            System.out.println("empty list");
            return;
        }
        else if(head.next == null){
            head = tail = null;
        }
        else if(head.next == tail){
            head = head.next;
            tail.next = null;
        }
        else{
            tail.next = head.next;
            head = head.next;
        }
    }

    //Deleting Node form end

    public void Delete_end(){
        if(head == null){
            System.out.println("empty list");
            return;
        }
        else if(head.next == null){
            head = tail = null;
        }
        else if(head.next == tail){
            tail = head;
            head.next = null;
        }
        else{
            Node new_node = head;
            while(new_node.next!=tail){
                new_node = new_node.next;
            }
            new_node.next = head;
            tail = new_node;

        }
    }

    //Deleting Node from anywhere

    public void Delete_anywhere(int p){
        Node current = head;
        Node pre = null;
        int i = 1;
        if(current==null){
            System.out.println("underflow");
            return;
        }
        else if (current.next==null){
            Delete_start();
        }
        else{
            while(i<p){
                pre = current;
                current = current.next;
                if(current == null){
                    break;
                }
                i++;
            }
            if (pre != null) {
                pre.next = pre.next.next;
            }
        }

    }
    //DELETE A SPECIFIC VALUE

    public void Delete_value(int v){
        Node current = head;
        Node pre = null;

        if(current==null){
            System.out.println("underflow");
            return;
        }
        else if (current.next==null){
            while(current.data!=v){
                pre = current;
                current = current.next;
                if(current == null){
                    break;
                }
            }
            if (pre != null) {
                pre.next = pre.next.next;
            }
        }
        else{
            while(current.data!=v){
                pre = current;
                current = current.next;
                if(current == null){
                    break;
                }
            }
            if (pre != null) {
                pre.next = pre.next.next;
            }
        }

    }

    //reversing cll

    public void reverse(int count){
        if (count >= 2) {
          Node p = null,q = head,r = head.next;
            tail = q;
            q.next = null;
            while (r!=tail){
                p=q;
                q=r;
                r=r.next;
                q.next=p;
            }
            head = q;
            tail.next = head;

        }
    }

    //Sorting CLL

    public void sort(){
    Node current = head;
    Node index = null;
    int temp;
    if(head == null){
        return;
    }
    else{
        do{
            index = current.next;
            while (index!=head){
                if(current.data > index.data){
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }while(current!=head);
    }

    }


    //printing list

    public void printList(){
        Node current = head;
        if(head ==  null){
            System.out.println("Empty list");
        }
        else{
            do{
                System.out.println(current.data);
                current = current.next;
            }while(current!=head);
        }

    }


    public static void main(String[] args) {
        CircularLinkedList_GFG list = new CircularLinkedList_GFG();
        list.add(10);
        list.add(2);
        list.add(13);
        list.add(4);
        list.add(45);
        list.instert_end(55);

//        list.insert_start(100);
//        list.instert_end(200);
//        list.insert_anywhere(1000,5);
//        list.Delete_start();
//        list.Delete_end();
//        list.Delete_anywhere(4);
//        list.Delete_value(45);

        list.sort();
        list.printList();
        list.count();
//        list.search(45);

//        list.reverse(list.count());
//        list.sort();
//        list.printList();
    }
}
