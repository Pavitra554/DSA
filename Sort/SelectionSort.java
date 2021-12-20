package DATA_STRUCTURE.Sort;
import java.util.*;

public class SelectionSort {

    static void selectionSort(int arr[]){
        //for getting maximum index for each iteration
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - i - 1;
            int maxIndex = getMax(arr,0,end);

            //swaping the max element index with his correct position
            int temp = arr[maxIndex];//arr[maxIndex] = maximum element
            arr[maxIndex ] = arr[end];//arr[end] = last element in array
            arr[end] = temp;// now end is equal to max element
        }
    }

    static int getMax(int arr[],int start,int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //Selection Sort Algorithm
        // Basically find the minimum / mmaximum element in the array and place it in his correct index
        //Time --> O(N^2)
        //Space --> O(1)
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

        //Selection Sort function
        selectionSort(arr);

        //Printing array after sorting
        System.out.println("Array after Selection Sort...\n");
        System.out.println(Arrays.toString(arr));


        s.close();
    }
}