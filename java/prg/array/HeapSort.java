package prg.array;

import prg.Out;
import prg.Out.Util;

import java.util.Arrays;


/**
 *  When creating a heap ordered array including the 0th index,
 *  for a position 'k',
 *  if k == even, parent of k is k/2 - 1.
 *  if k == odd, parent of k is k/2.
 *  Children, leftchild -> 2k + 1, 2k + 2
 *
 *  When creating a heap ordered array excluding the 0th index, i.e first element starts from 1 not from zero.
 *  and total size of arra is N+1, where  N is the total elements.
 *  for a position 'k',
 *  parent of k is k/2.
 *  Children, -> 2k, 2k + 1
 */
public class HeapSort {

    public static void main(String[] args) {
        int [] a = {11,10,9,3,15,5,8,1,6,4};
        Out.println("Before: "+ Arrays.toString(a));
        sort(a);
        Out.println("After: "+ Arrays.toString(a));

    }

    //Using 0 index
    public static void sort(int [] a) {
        int N = a.length -1;
        for (int k = N/2; k >= 0; k--) {
            sink(a, k, N);
        }

        while (N >= 0) {
            Util.swap(a,0,N);
            sink(a, 0, --N);

        }
        Util.swap(a,0,1);
    }

    private static void sink(int [] a, int parentIndex, int endIndex) {

        int childIndex = getBiggerChildIndex(a,parentIndex,endIndex);

        while( childIndex < endIndex && a[childIndex] > a[parentIndex]) {
            // swap parentElement with childElement
            Util.swap(a, parentIndex, childIndex);
            // checking if parentElement can still sink further down.
            parentIndex = childIndex;
            childIndex = getBiggerChildIndex(a, parentIndex,endIndex);
        }

    }

    private static int getBiggerChildIndex(int [] a, int parentIndex, int endIndex) {
        int c = 2 * parentIndex + 1 ;

        if (c >= endIndex ) return parentIndex ;

        return a[c] > a[c+1] ? c: c+1;
    }

    private static void swim(int [] a, int startIndex, int endIndex) {

    }
}
