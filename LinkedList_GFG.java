package DATA_STRUCTURE;

import java.util.Scanner;

public class LinkedList_GFG {
    Node head;
    //creation
    static class Node{
        int value;
        Node next;
        Node(int d){
            value = d;
            next = null;
        }
    }


    //printing
    public void printlist(){
        Node n = head;
        while (n!=null){
            System.out.println(n.value+" ");
            n = n.next;
        }
    }
    //counting nodes

    public int countNODE(){
        Node c = head;
        int count = 1;
        while (c.next != null){
            count++;
            c = c.next;
        }
        System.out.println("Total number of Nodes : "+count);
        return count;
    }


    //insertion at Start
    public void add_start(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    //insertion at end
    public void add_end(int data){
        Node new_Node = new Node(data);
        if (head == null){
            head = new Node(data);
            return;
        }

        new_Node.next  = null;
        Node last = head;

        while(last.next!=null){

            last = last.next;
        }
        last.next = new_Node;
        return;

    }

    //Insert anywhere
    public  void add_anywhere(int data,int p){
        Node node = new Node(data);
        node.next = null;
        if(this.head == null){
            if(p !=0){
                return;
            }else{              //when head is null
                this.head = node;
            }
        }
        if(head!=null && p == 0){
            node.next = this.head; //when position is zero
            this.head = node;
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
        node.next = current_node;
        pre.next = node;
    }
    //Delete Node from start
    public void del_start(){
        if (head == null){
            return;
        }
        head = head.next;
    }
    //Delete Node from end
    public void del_end(){
        Node check = head;
        if(check!=null){
            while(check.next.next != null){
                check = check.next;
            }
            check.next = null;
        }
        else{
            System.out.println("underflow");
        }

    }
    //Delete Node from a specific position
    public void del_anywhere(int p){
        Node current = head;
        Node pre = null;
        int i = 1;
        if(current==null){
            System.out.println("underflow");
            return;
        }
        else if (current.next==null){
            del_start();
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

    public void search(int d){
        int p = 0;
        Node n = head;
        while(n!=null){
            p++;
            if(d == n.value){
                System.out.println(d+" is in Node "+p);
                break;
            }
            n = n.next;
        }

    }


    public void reverseList(int count){
        if (count>=2){
            Node p = null,q = head,r = head.next;
            q.next = null;
            while (r!=null){
                p=q;
                q=r;
                r=r.next;
                q.next=p;
            }
            head = q;
        }
    }

    public void sort(){
        Node current = head;
        Node index = null;
        int temp;
        if (head == null){
            return;
        }
        else{
            while(current != null){
                index = current.next;

                while(index != null){
                    if(current.value > index.value){
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        LinkedList_GFG list = new LinkedList_GFG();

//        list.head = new Node(1);
//        Node two = new Node(2);//creating Nodes
//        Node three = new Node(3);
//        Node four  = new Node(4);

        //Linking nodes;

        //list.head.next = two;// 1 --> 2
        //two.next = three;//1 --> 2 --> 3
        //three.next = four;//1 --> 2 --> 3 -->4 -->null

        list.add_end(1);
        list.add_end(2);
        list.add_end(5);
        list.add_end(4);
        list.add_end(3);
        list.add_end(37);
        list.add_end(3);
        list.add_anywhere(1000,4);

        list.del_end();
        list.del_start();
//        list.reverseList(list.countNODE());


//        list.add_end(1);
//        list.add_end(2);
//        list.add_end(3);
//        list.add_end(4);
//        list.add_end(5);
//        list.add_end(6);
//        list.del_start();
//        list.del_end();
//        list.del_anywhere(4);
//        list.del_anywhere(2);


//        list.add_anywhere(5000,3);
//        list.add_anywhere(4000,4);
//        list.add_anywhere(1000,5);
            list.sort();

//        list.add_anywhere(123456, list.countNODE(),2);

        list.printlist();//printing list
//        list.search(3);
//        list.countNODE();//counting Node
//        list.reverseList(list.countNODE());//reversing
//        list.printlist();//printing list





    }
}
