package DATA_STRUCTURE.Sort;

import java.util.*;

public class Counting_Sort {
    static int findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort(int arr[]) {
        int count[] = new int[findMax(arr) + 1];
        int sort[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Important Loop
        System.out.println(Arrays.toString(count)); // Modified count array [0,3,7,8]

        for (int i = 0; i < arr.length; i++) {
            sort[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < sort.length; i++) {
            arr[i] = sort[i];
        }
        System.out.println(Arrays.toString(count)); // Final count array [0,0,3,7]

    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 2, 3, 2, 2, 1, 1 };
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
