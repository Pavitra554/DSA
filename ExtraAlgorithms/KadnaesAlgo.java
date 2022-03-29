package DATA_STRUCTURE.ExtraAlgorithms;

public class KadnaesAlgo {
    // O(n)
    // This will return largest possible sum of subarray from given array
    static int maxSubarraySum(int arr[], int n) {
        int MaxSum = -Integer.MAX_VALUE;
        int CurrentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            CurrentSum += arr[i];
            if (CurrentSum > MaxSum) {
                MaxSum = CurrentSum;
            }
            if (CurrentSum < 0) {
                CurrentSum = 0;
            }
        }
        return MaxSum;
    }

    public static void main(String[] args) {
        int arr[] = { -1, -2, -3, -4 };
        System.out.println(maxSubarraySum(arr, 4));
    }
}
