package prg.array;

import prg.Util;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {12,2,15,4,7,1};
        System.out.println("before: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("after: "+ Arrays.toString(arr));
    }

    private static void sort(int [] ar) {
        for (int i = 0 ; i < ar.length ; i++) {
            Util.swap(ar, i, selectMin(ar, i));
        }
    }

    private static int selectMin(int[] ar, int start) {
        int min = Integer.MAX_VALUE;
        int minInd = start;
        for(int i = start; i < ar.length ; i++){
            if (ar[i] < min) {
                min = ar[i];
                minInd = i;
            }
        }

        return minInd;
    }
}
