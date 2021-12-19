package DATA_STRUCTURE.Search;

import java.util.Scanner;

public class Linear {

    static String linearSearch(int []arr,int n){
        for (int i = 0; i < arr.length; i++) {
            //checking target with every element
            if(n == arr[i]){
                return "Index is " + i;
            }
        }
        return "Element does'nt exists in array";
    }
    public static void main(String[] args) {
        //Linear Search Algorithm
        //Time -> O(n)
        //Space ->  O(1)
        Scanner s =  new Scanner(System.in);
        System.out.println("Enter total no of elements in array : ");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements one by one ...");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Enter which element location you want to check : ");
        int target = s.nextInt();
        System.out.println(linearSearch(arr, target));
        
        s.close();
    }
}
