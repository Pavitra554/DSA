package DATA_STRUCTURE.Sort;

import java.util.*;

public class BucketSort {
    static void bucketSort(float arr[], int n) {
        if (n <= 0) {
            return;
        }

        // Creating array of lists
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Creating empty list for each index
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // adding values in buckets
        for (int i = 0; i < n; i++) {
            buckets[(int) arr[i] * n].add(arr[i]);
        }

        // sorting each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // adding sorted values to the origin array (arr)
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[k++] = buckets[i].get(j);
            }
        }

    }

    public static void main(String[] args) {
        float arr[] = { 0.32f, 0.12f, 0.18f, 0.32f, 0.35f, 0.45f, 0.10f };
        bucketSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
