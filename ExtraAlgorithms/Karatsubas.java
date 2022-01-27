package DATA_STRUCTURE.ExtraAlgorithms;

import java.util.Scanner;

public class Karatsubas { 
    static long multiply(long x,long y){
        
        int s1 = String.valueOf(x).length();
        int s2 = String.valueOf(y).length();

        int n = (int)Math.max(s1, s2);

        if(n<10){
            return x*y;
        }

        long b_t_p_n = (long)Math.pow(2, n);
        long b_t_p_nbi2 = (long)Math.pow(2, n/2);

        long x1 = x / b_t_p_nbi2;
        long x0 = x-x1*b_t_p_nbi2;
        long y1 = y / b_t_p_nbi2;
        long y0 = y-y1*b_t_p_nbi2;

        long p = multiply((x1+x0),(y1+y0));

        long x1y1 = multiply(x1, y1);
        long x0y0 = multiply(x0, y0);

        return x1y1*b_t_p_n + ((p - x1y1 - x0y0) * b_t_p_nbi2) + x0y0;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number : ");
        long num1 = s.nextLong();
        System.out.println("Enter the second number : ");
        long num2 = s.nextLong();
        System.out.println(multiply(num1,num2));
        s.close();
    }
}
