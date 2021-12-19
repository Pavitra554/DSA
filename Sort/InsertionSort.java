package DATA_STRUCTURE.Sort;
import java.util.*;

public class InsertionSort {
    static void insertionSort(int []arr){
        //it will size of array minus 2
        for (int i = 0; i < arr.length-1; i++) {
            //it will run till left side of the array and will sort the left part
            for (int j = i+1; j>0; j--) {
                //swaping elements
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else{
                    //if left side is already sorted than break for the iteration
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        //Insertion Sort Algorithm
        //Best case --> O(N)
        //Wrost case --> O(N^2)
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

        //Sorting function
        insertionSort(arr);

        //Printing sorted array
        System.out.println(Arrays.toString(arr));

        s.close();
    }
}
