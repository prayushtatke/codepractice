package prg.array;

import prg.Util;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {12,2,15,4,7,1};
        System.out.println("before: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("after: "+ Arrays.toString(arr));
    }

    private static void sort(int [] arr ) {

        for (int i = 1 ; i < arr.length ; i++ ){
            System.out.print("i: "+i+", ");
            if ( arr[i-1] > arr [i])
                swapRecursive(arr, i -1 , i);

            System.out.println();
        }


    }

    private static void swapRecursive(int [] ar, int i, int j) {
        if (i < 0 || ar[i] < ar[j] )
            return ;

        Util.swap(ar, i, j);
        System.out.print("-> afterSwap: "+ Arrays.toString(ar));
        swapRecursive(ar, i-1 , i);
    }
}
