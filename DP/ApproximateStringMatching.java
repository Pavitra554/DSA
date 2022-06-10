package DATA_STRUCTURE.DP;

import java.util.*;

public class ApproximateStringMatching {
    static int matchings(String t, String p) {
        int n = t.length();
        int m = p.length();

        int M[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            M[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            M[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == p.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1];
                } else {
                    int min = Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1]));
                    M[i][j] = min + 1;
                }
            }
        }

        // Memoization Table
        // for (int i = 0; i <= n; i++) {
        // for (int j = 0; j <= m; j++) {
        // System.out.print(M[i][j] + " ");
        // }
        // System.out.println();
        // }

        return M[n][m];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string text: ");
        String t = s.next();
        System.out.println("Enter string p: ");
        String p = s.next();
        System.out.println("Total number of operations" + matchings(t, p));
        s.close();

    }
}
