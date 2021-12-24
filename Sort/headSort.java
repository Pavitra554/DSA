package DATA_STRUCTURE.Sort;

import java.util.*;

public class headSort {
    //This function gives the paraent of an node if exists
    static int parent(int i){
        return (i/2);
    }

    //This function gives the left child of an node if exists
    static int left(int i){
        return 2*i+1;
    }
        
    //This function gives the right child of an node if exists
    static int right(int i){
        return 2*i+2;
    }
    
    //Function for buliding max heap
    static void BUILD_MAX_HEAPFY(int arr[]){
        //Time = O(Log n)
        //Space = O(1)
        for (int i = arr.length/2; i>=0; i--) {
            MAX_HEAPFY(arr ,arr.length, i);
        }
    }

    //Function for heap property
    static void MAX_HEAPFY(int []arr,int n,int i){
        //Time = O(Log n)
        //Space = O(1)
        int left =left(i); //left child
        int right = right(i); // right child

        int largest = i;

        if(left < n && arr[left]>arr[i]){ 
            //checking if the parent is less than or grater than left child
            largest = left;
        }
        else{
            largest = i;
        }

        if(right < n && arr[right]>arr[largest]){
            //checking if the parent is less than or grater than right child
            largest = right;
        }
        if(largest != i){
            //if parent is not the largest than swaping parent with largest
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp; 

            //againg max_heapfy for the largest node
            MAX_HEAPFY(arr,n,largest);
        }
    }
   
    //for printing heap 
    static void PrintHeap(int []arr){

        for(int j=0;j<arr.length/2;j++){
            //loop is till length/2 because we are printing 3 element at a time
            int left  = 2*j+1;
            int right = 2*j+2;
            System.out.print("Parent Node : " + arr[j]);
             
            if(left<arr.length) 
               System.out.print( " Left Child Node: " + arr[left]);
             
            if(right<arr.length) 
                System.out.print(" Right Child Node: "+ arr[right]);
             
                System.out.println(); 
             
        }
    }


    //Heap Sort
    static void HeapSort(int arr[]){
        //Time = O(n*log n )
        //Space = O(1)


        BUILD_MAX_HEAPFY(arr);
        //For bulding max heapfy

        for (int i = arr.length-1; i > 0; i--) {
            //Exchanging root element with last element

            int temp  = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //calling max heapfy for total size - 1 so that it will ignore the last  element which is the largest.
            MAX_HEAPFY(arr,i, 0);
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

        // MAX_HEAPFY(arr,0);
        // BUILD_MAX_HEAPFY(arr);

        //Heap Sort function
        HeapSort(arr);


        //Printing Heap
        PrintHeap(arr);

        //Printing array
        System.out.println(Arrays.toString(arr));


        s.close();
    }
}
