package DATA_STRUCTURE.Sort;

import java.util.*;

public class Counting_Sort {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 4, 1, 5, 8, 1, 4, 6, 1 };
        int ans[] = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[arr[i]]++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));

        int k = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i]; j++) {
                arr[k++] = i;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
