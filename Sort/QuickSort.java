package DATA_STRUCTURE.Sort;

import java.util.*;

public class QuickSort {

    //function for swaping two elements
    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //function for Quick Sort
    static void QSort(int a[],int start,int end){
        //The function will return if start is grater or equal to end
        if(start >= end){
            return;
        }

        int st = start;//starting index
        int e = end;//last index

        int mid = st + (e-st)/2;//the mid index of the array
        int pivot = a[mid];//chosing mid as the pivot element

        while(st <= e){

            while(a[st] < pivot){
                //if the a[previous element] is less then pivot then we will go forther
                st++;
            }
            while(a[e] > pivot){
                //if the a[forther element] is grater then pivot then we will go on decreasing e
                e--;
            }
            if(st <= e){
                swap(a, st, e);
                st++;
                e--;
                // System.out.println(Arrays.toString(a));//for checking the swaps
            }
            QSort(a, start, e);
            QSort(a, st, end);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of element in the array : ");
        int n = s.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements in the array..");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        QSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        s.close();
    }
}
