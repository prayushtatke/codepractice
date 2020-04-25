package prg.array;

import prg.Util;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int [] arr = {12,2,15,4,7,1};
        System.out.println("before: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("after: "+ Arrays.toString(arr));

    }

    public static void sort(int [] ar) {
        sortRecursive(ar, 0, ar.length -1);
    }

    private static void sortRecursive(int [] ar, int start, int end) {
        if (start >= end )
            return;

      // pivot is an index such that, values from start to (pivot -1) are less than ar[pivot].
      // and values from pivot to end are greater than ar[pivot].
      int pivot = partition(ar,start,end);
      sortRecursive(ar, start, pivot-1);
      sortRecursive(ar, pivot +1 , end);
    }

    private static int partition(int [] ar, int start, int end) {
        int pivotInd = (start + end)/2;
        int pivotVal = ar[pivotInd];

        while (start < end  && pivotInd < end && pivotInd > start) {
            if (ar[start] > pivotVal && ar[end] < pivotInd) {
                Util.swap(ar, start, end);
                start++;
                end--;
            } else if (pivotInd > start && ar[start] >= pivotVal){
                Util.swap(ar, start, pivotInd);
                pivotInd = start;
                start++;
            } else if ( pivotInd < end && ar[end] < pivotVal) {
                Util.swap(ar, end, pivotInd);
                pivotInd = end;
                end--;
            }

        }
        return pivotInd ;
    }
}
