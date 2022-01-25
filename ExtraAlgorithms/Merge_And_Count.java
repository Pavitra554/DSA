package DATA_STRUCTURE.ExtraAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_And_Count {
    static void mergeCount(int[]ans,int[]a,int []b){
        int i = 0,j = 0,k = 0;

        int count = 0;

        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                ans[k] = a[i];
                i++;
                k++;
            }
            else{
                ans[k] = b[j];
                k++;
                j++;
                count += a.length - i;
            }
        }
        while(i<a.length){
            ans[k] = a[i];
            k++;
            i++;
        }
        while(j<b.length){
            ans[k] = b[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(ans));
        System.out.println("Merge Count : "+count);


    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Taking input for first array
        System.out.println("Enter the size of first array : ");
        int n1 = s.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter the elements in the first array : ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }
        //Taking input for second array
        System.out.println("Enter the size of second array : ");
        int n2 = s.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Enter the elements in the second array : ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }

        //Answer Array
        int ans[] = new int[n1+n2];
        mergeCount(ans, arr1, arr2);


        s.close();
    }
}
