package DATA_STRUCTURE.LeetCode.Easy;

public class SingleNumber {
    static int singleNumber(int[] nums) {
        int snum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            snum = snum ^ nums[i];
        }
        return snum;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(arr));
    }
}
