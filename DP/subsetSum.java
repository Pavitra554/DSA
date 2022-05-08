package DATA_STRUCTURE.DP;

public class subsetSum {
    static boolean isSubSetSum(int set[], int n, int sum) {

        boolean subset[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            subset[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            subset[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] > j) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(subset[i][j] + " ");
            }
            System.out.println();
        }
        return subset[n][sum];
    }

    public static void main(String[] args) {
        int set[] = { 1, 3, 9, 2 };
        int sum = 5;
        boolean issubSet = isSubSetSum(set, set.length, sum);

        if (issubSet) {
            System.out.println("Yes, There is exists a subset whose sum is " + sum);
        } else {
            System.out.println("No, There is no such subset exists whose sum is " + sum);
        }

    }
}
