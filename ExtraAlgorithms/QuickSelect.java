package DATA_STRUCTURE.ExtraAlgorithms;

import java.util.Arrays;

public class QuickSelect {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int arr[], int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int st = start;
        int e = end;
        int mid = st + (e - st) / 2;
        int pivot = arr[mid];
        while (st <= e) {
            while (arr[st] < pivot) {
                st++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (st <= e) {
                swap(arr, st, e);
                st++;
                e--;
            }

            // Little bit modification in quick sort
            if (k < end) {
                quickSort(arr, start, e - 1, k);
            } else {
                quickSort(arr, st + 1, end, k);
            }

        }
    }

    //
    static int quickSelect(int arr[], int start, int end, int k) {
        quickSort(arr, start, end, k);
        return arr[k];
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 2, 0, 5, 6, 9, 8, 4 };
        int kth = quickSelect(arr, 0, arr.length - 1, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(kth);// This will print Kth smallest element in the array
    }
}
