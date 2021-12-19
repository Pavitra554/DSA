package DATA_STRUCTURE.Sort;

import java.util.*;

public class MergeSort {
    static void sort(int arr[],int start, int end){
        //run till size of array is 1
        if(start<end){

            //mid =  middle index
            int mid = start + (end-start)/2;

            //dividing frist half of the array
            sort(arr,start,mid);

            //dividing second half of the array
            sort(arr,mid+1,end);

            //Merging the arrays
            merge(arr,start,mid,end);
        }
    }

    static void merge(int[]arr,int start,int mid,int end){
        int n1 = mid-start+1; //size of left array
        int n2 = end - mid; // size of right array

        int L[] = new int[n1];
        int R[] = new int[n2];

        //adding first half in left array
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[start+i]; 
        }
        //adding second half in right array
        for (int j = 0; j < n2; ++j){
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i<n1 && j<n2) {
            if(L[i] <= R[j]){ 
                //if left is small add left and increment left array's index
                arr[k] = L[i];
                i++;
            }else{
                //if right is small add right and increment right array's index
                arr[k] = R[j];
                j++;
            }
            //after adding one element ( either from left or right ) increment 
            //answer array's index
            k++; 
        }

        //this loop is for the remaining element in the left array
        //because there exists such a case that size of both arrays are different 
        //so the upper loop will stop after same iteration for both loop
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        //this loop is for the remaining element in the left array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Function for printing array
    static void printArray(int arr[]){
        System.out.println("The sorted Array....");
        for (int e : arr) {
            System.out.print(e+" ");
        }
    }
    public static void main(String[] args) {
        //Merge Sort Algorithm
        //Time --> O(N * log base 2 N)
        //Space --> O(N)
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

        //Merge Sort function
        sort(arr, 0, arr.length-1);
        
        System.out.println("After merge sort..");
        //Printing array
        printArray(arr);

        s.close();
    }
}
