package DATA_STRUCTURE.DP;

import java.util.Scanner;

public class Fibonacci {
    // Fibonacci serise using Dynamic Programming
    // Time --> O(n);
    // Space --> O(n)

    static int fib(int n) {
        int f[] = new int[n + 2];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter nummber : ");
        int n = s.nextInt();
        System.out.println(n + " Fibonacci number is " + fib(n));
        s.close();
    }
}
