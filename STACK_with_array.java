package DATA_STRUCTURE;

public class STACK_with_array {
    static final int max = 6;
    int top = -1;                   //LAST IN FIRST OUT (LIFO)
    int []arr = new int[max];

    public boolean isFull(){ //Checking whether the stack is full or not
        if(top == (max-1)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmpty(){ //Checking whether the stack is empty or not
        if(top==-1){
            return  true;
        }
        else {
            return false;
        }
    }

    boolean push(int d){ //pushing elements into stack
        if(isFull()){
            System.out.println("Stack Overflow..!");
            return false;
        }
        else{
            arr[++top] = d;
            System.out.println(d+" pushed into stack");
            return true;
        }
    }
     void pop(){//removing elements from stack
         if(isEmpty()){
             System.out.println("Stack Underflow");
         }
         else{
             int x = arr[top--];
             System.out.println(x+" Removed from stack");
         }
     }

     void display(){

        while(top>=0){    //DOUBT???????????
            System.out.println(arr[top]);
            top--;
        }
     }

     void peek(){
        if(isEmpty()){
            return;
        }
        else{
            System.out.println("Top is "+arr[top]);
        }
     }

    public static void main(String[] args) {
        STACK_with_array  s = new STACK_with_array();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.peek();
        s.pop();
        s.pop();
        s.peek();

        System.out.println("\n\n");
        s.display();
        System.out.println();

    }
}
