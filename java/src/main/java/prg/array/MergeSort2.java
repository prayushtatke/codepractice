package prg.array;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int [] arr = {12,2,15,4,7,1};
        System.out.println("before: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("after: "+ Arrays.toString(arr));

    }

    public static void sort(int [] arr){
       mergeSort(arr,0, arr.length-1);
    }

    private static void mergeSort(int [] ar, int start, int end) {

        if ( start >= end )
            return;

        int mid = (end + start )/2 ;
        mergeSort(ar, start, mid);
        mergeSort(ar, mid+1, end);
        merge(ar,start,mid,end);
    }

    private static void merge(int [] ar, int start,int mid, int end) {
        System.out.println("start: "+start+", mid:"+mid+", end: "+end);
        int [] larr = new int[mid -start + 1];
        int [] rarr = new int [end -mid];

        System.arraycopy(ar,start,larr ,0 , mid- start+1);
        System.arraycopy(ar,mid+1 ,rarr ,0 , end - mid);

        int i =0, j = 0 , k = start;
        while( i < larr.length && j < rarr.length ) {
            if (larr[i] < rarr[j])
                ar[k++] = larr[i++];
            else
                ar[k++] = rarr[j++];

        }

        while (i < larr.length ) {
            ar[k++] = larr[i++];
        }

        while (j < rarr.length ) {
            ar[k++] = rarr[j++];
        }
    }

}
