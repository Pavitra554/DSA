package DATA_STRUCTURE.DP;

public class MatrixChainMultiplication {

    static int MatrixChain(int arr[], int n) {
        // making 2D-Array of size n x n
        int m[][] = new int[n][n];
        int multiplicationCount = 0;// initial no of multiplication

        // making all diagonal elements 0
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (j == n) {
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    multiplicationCount = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (multiplicationCount < m[i][j]) {
                        // Adding minimum cost to multiply A1...An
                        m[i][j] = multiplicationCount;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    // final array for the given input
    // 0 6 18
    // 0 0 24
    // 0 0 0

    // here 18 is the minimum cost

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int size = arr.length;
        System.out.println("Minimum number of multiplications is " + MatrixChain(arr, size));
    }
}
