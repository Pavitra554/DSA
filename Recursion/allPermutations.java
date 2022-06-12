package DATA_STRUCTURE.Recursion;

import java.util.Arrays;

public class allPermutations {
    static void permutations(int[] arr, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, start, i);
            permutations(arr, start + 1, end);
            swap(arr, start, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        permutations(arr, 0, arr.length - 1);
    }

}
