package DATA_STRUCTURE.LeetCode.Medium;

import java.util.Scanner;

public class Reverse_Integer {
    public static int reverse(int x) {
        long res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(reverse(n));
        s.close();
    }
}
