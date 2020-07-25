package prg.array;

import prg.Out.Util;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {12,2,15,4,7,1};
        System.out.println("before: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("after: "+ Arrays.toString(arr));

    }

    private static void sort(int [] arr) {
        for (int i = arr.length ; i > 0 ; i--) {
            for (int j = 1; j < i ; j ++) {
                if (arr[j-1] > arr[j])
                    Util.swap(arr, j-1, j);
            }
        }

    }
}
