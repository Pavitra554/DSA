package DATA_STRUCTURE;

import java.util.*;

public class Heap {
 
    //ERROR! this is not working.

    static void MAX_HEAP(int arr[]){
        for (int i = (arr.length) / 2; i >= 0 ; i--) {
            HEAPFY(arr, i);
        }
    }

    static void HEAPFY(int []arr,int i){
        int left = 2*i+1;
        int right = 2*i+2;

        int largest = i;

        if(left <= arr.length && arr[left]>arr[largest]){
            largest = left;
        }
        else{
            largest = i;
        }

        if(right <= arr.length && arr[right]>arr[largest]){
            largest = right;
        }
        else{
            largest = i;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp; 
            HEAPFY(arr, largest);
        }
    }

   

    static void PrintHeap(int []arr){
        for(int j=0;j<arr.length/2;j++){
            int left  = 2*j+1;
            int right = 2*j+2;
            System.out.print("Parent Node : " + arr[j]);
             
            if(left<arr.length) //if the child is out of the bound of the array
               System.out.print( " Left Child Node: " + arr[left]);
             
            if(right<arr.length) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: "+ arr[right]);
             
                System.out.println(); //for new line
             
        }
    }
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        
        //Taking size of array
        System.out.println("Enter total no of elements in array : ");
        int n = s.nextInt();
         int[] arr = new int[n];

        //Taking each element in the array
        System.out.println("Enter array elements one by one ...");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        // HEAPFY(arr,0);
        MAX_HEAP(arr);
        PrintHeap(arr);
        System.out.println(Arrays.toString(arr));


        s.close();
    }
}
