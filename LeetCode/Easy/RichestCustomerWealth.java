package DATA_STRUCTURE.LeetCode.Easy;

public class RichestCustomerWealth {
    static int maximumWealth(int[][] accounts) {
        int ans = -Integer.MAX_VALUE;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };
        System.out.println(maximumWealth(arr));
    }
}
