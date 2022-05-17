package DATA_STRUCTURE.Sort;

import java.util.*;

public class RadixSort {
    static int findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort(int arr[], int in, int n) {
        int count[] = new int[findMax(arr) + 1];
        int sort[] = new int[arr.length];

        // modification in count sort
        for (int i = 0; i < n; i++) {
            count[(arr[i] / in) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Important Loop
        // System.out.println(Arrays.toString(count)); // Modified count array [0,3,7,8]

        // modification in count sort
        for (int i = n - 1; i >= 0; i--) {
            // modification
            sort[count[(arr[i] / in) % 10] - 1] = arr[i];
            count[(arr[i] / in) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = sort[i];
        }

        // System.out.println(Arrays.toString(count)); // Final count array [0,0,3,7]

    }

    static void radixSort(int arr[], int n) {
        int max = findMax(arr);
        // Main
        for (int i = 1; (max / i) > 0; i *= 10) {
            countSort(arr, i, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 121, 432, 564, 23, 1, 45, 788 };
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
