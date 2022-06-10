package DATA_STRUCTURE.DP;

public class Zero_By_One_Knapsack {
    static int maxProfit(int w[], int p[], int n, int C) {
        int M[][] = new int[n + 1][C + 1];

        // Initillazing
        for (int i = 0; i < n + 1; i++) {
            M[i][0] = 0;
        }
        // Initillazing
        for (int i = 0; i < C + 1; i++) {
            M[0][i] = 0;
        }

        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (w[i - 1] > j) {
                    M[i][j] = M[i - 1][j];
                } else {
                    if ((p[i - 1] + M[i - 1][j - w[i - 1]]) > M[i - 1][j]) {
                        M[i][j] = p[i - 1] + M[i - 1][j - w[i - 1]];
                    } else {
                        M[i][j] = M[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < w.length + 1; i++) {
            for (int j = 0; j < C + 1; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        return M[n][C];
    }

    public static void main(String[] args) {
        int w[] = { 3, 2, 5, 4 }; // Weights
        int p[] = { 10, 8, 12, 9 };// profits
        int C = 8;// Capacity
        System.out.println("Maximum profit is " + maxProfit(w, p, w.length, C));
    }
}
