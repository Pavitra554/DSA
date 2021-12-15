package DATA_STRUCTURE.Search;

import java.util.Scanner;

public class Linear {

    static String linearSearch(int []arr,int n){
        for (int i = 0; i < arr.length; i++) {
            if(n == arr[i]){
                return "Index is " + i;
            }
        }
        return "Element does'nt exists in array";
    }
    public static void main(String[] args) {
        //Linear Search Algorithm
        //O(n)
        Scanner s =  new Scanner(System.in);
        int[] arr = { 1, 2, 3, 45, 6, 7, 9, 5};
        System.out.println("Enter which element location you want to check : ");
        int n = s.nextInt();
        System.out.println(linearSearch(arr, n));
        
        s.close();
    }
}
