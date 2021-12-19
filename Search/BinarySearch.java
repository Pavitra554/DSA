package DATA_STRUCTURE.Search;

import java.util.Scanner;

public class BinarySearch {
    //Binary search
    //Time O(log n)
    //Space O(1)
    static int binarySearch(int []arr,int target){
        int start = 0;
        int end = arr.length-1;

        //checking for aescending order 
        boolean checkAc = arr[start] < arr[end];
        
        while(start<=end){
            int mid = start + (end-start)/2;

            //answer
            if(arr[mid] == target) return mid;

            if(checkAc){ //aescending
                if(target<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{ //descending
                if(target>arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        //if not found
        return -1;

    }
    public static void main(String[] args) {
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
        int ans = binarySearch(arr, target);
        if( ans != -1){
            System.out.println("Index is "+ans);
        }else{
            System.out.println("Element not exists");
        }
        s.close();
    }
}
