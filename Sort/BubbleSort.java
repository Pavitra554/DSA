package DATA_STRUCTURE.Sort;
import java.util.*;
public class BubbleSort {
    static void bubbleSort(int []arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            //first loop for each pass
            for (int j = 1; j < arr.length-i; j++) {
                //2nd loop for placing each largest element in his position
                if(arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
                //for checking after each pass how the elements are changing position
                // System.out.println(Arrays.toString(arr));
                
            }
            System.out.println();
            if(swapped == false){
                break;
            }
        }
    }
    public static void main(String[] args) {
        //Bubble Sort Algorithm
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
        bubbleSort(arr);

        //Printing sorted array
        System.out.println(Arrays.toString(arr));

        s.close();
    }
}
