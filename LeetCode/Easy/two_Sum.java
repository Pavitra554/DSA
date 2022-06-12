package DATA_STRUCTURE.LeetCode.Easy;

import java.util.Scanner;

public class two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }

            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = 6;
        int[] arr = { 3, 3 };
        int[] ans = twoSum(arr, t);
        for (int e : ans) {
            System.out.println(e);
        }
        s.close();
    }
}
