package DATA_STRUCTURE.LeetCode.Easy;

public class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int maxsum = -Integer.MAX_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > maxsum) {
                maxsum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }
}
