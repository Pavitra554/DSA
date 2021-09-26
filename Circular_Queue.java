package DATA_STRUCTURE;

public class Circular_Queue {
    static final int max = 5;
    int front = -1;int rear = -1;
    int []queue = new int[max];

//    boolean isFull(){
//        if((rear+1)%max == front){
//            System.out.println("Overflow!");
//            return true;
//        }
//        return false;
//    }

    void insert(int d){
        if((rear+1)%max == front){
            System.out.println("Queue is full");
        }
        else if(front == -1 && rear == -1){
            front = rear = 0;
        }
        else if ((rear == max-1) && (front!=0)){
            rear = 0;
        }
        else{
            rear = (rear+1)%max;
        }
        queue[rear] = d;
    }
    void display(){
        if(front == -1){
            System.out.println("Underflow");
        }
        else{
            System.out.println("Element present ");
            for (int i = front; i <=rear ; i++) {
                {
                    System.out.println(queue[i]);
                }
            }
        }

    }
    void delete(){
        if(front == -1){
            System.out.println("Queue is empty..!");
        }
        else if(front == rear){
            front = rear =-1;
        }
        else{
            int n = queue[front];
            front = (front+1)%max;
            System.out.println(n+" Deleted! form queue");
        }
    }
    public static void main(String[] args) {
        Circular_Queue cq = new Circular_Queue();
        cq.insert(14);
        cq.insert(15);
        cq.insert(16);
        cq.insert(17);
        cq.insert(18);
//        cq.delete();
        cq.delete();
//        cq.delete();
        cq.delete();

        cq.display();
        System.out.println("\n\n");

    }
}
