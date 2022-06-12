package DATA_STRUCTURE.LeetCode.Easy;

public class SearchInsertPosition {
    // Success
    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        boolean isAcc = nums[start] < nums[end];

        while (start <= end) {

            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if (isAcc) {
                if (nums[mid] > target) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        if (nums[mid] < target) {
            return mid + 1;
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int arr[] = { -1, 3, 5, 7 };
        System.out.println(searchInsert(arr, 0));

    }
}
