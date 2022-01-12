package DATA_STRUCTURE.ExtraAlgorithms;

import java.util.Arrays;

public class Interval_scheduling {
    public static void main(String[] args) {
        //Intervel scheduling
        int [] start = {1, 3, 4, 5, 9, 2};
        int [] finish = {2, 4, 9, 8, 10, 4};

        //1-----2        4----------9
        //        3-----4    5----8 9-----10
        //      2-------4 
        // Answer --->   1----2
        //               3----4
        //               5----8
        //               9----10

        int n = 0;

        for (int i = 0; i < finish.length; i++) {
            for (int j = 1; j < finish.length - i; j++) {
                if(finish[j]<finish[j-1]){
                    int temp = finish[j];
                    finish[j] = finish[j-1];
                    finish[j-1] = temp;
                    int t1 = start[j];
                    start[j] = start[j-1];
                    start[j-1] = t1;
                }
            }
        }
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(finish));
        System.out.println(n+" ");
        for (int i = 1; i < start.length; i++) {
            if(start[i] >= finish[n]){
                System.out.println(i+" ");
                n = i;
            }
        }
    }
}
