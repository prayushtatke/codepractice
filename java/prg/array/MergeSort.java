package prg.array;

import java.util.Arrays;

public class MergeSort {


    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12,2,15,4,7,1};

        System.out.println("Given Array");
        printArray(arr);
        mergesort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    public static void mergesort(int [] ar) {
        mergesort(ar, 0, ar.length -1 );
    }

    public static void mergesort(int [] ar,int l , int r) {
        if ( l >= r ) return;

        {

            int mid = (l + r) / 2;
            System.out.println("start: "+l+", mid:"+mid+", end: "+l);
            mergesort(ar, l, mid);
            mergesort(ar, mid + 1, r);
            merge(ar, l, mid, r);
        }
    }

    private static void merge(int [] arr, int left,int mid, int right) {
        // creating temp array
        int [] larr = new int [mid - left +1];
        int [] rarr = new int [right -mid];

        // populate these temp array;
        System.arraycopy(arr,left ,larr ,0 , mid- left+1);
        System.arraycopy(arr,mid+1 ,rarr ,0 , right -mid);
//        for (int i = 0; i < larr.length; i++) {
//            larr[i] = arr[left+i];
//        }

//        for (int i = 0; i < rarr.length; i++) {
//            rarr[i] = arr[mid +1 +i];
//        }

        // merge these two array
        int i = 0 ;
        int j = 0;
        int k = left;
        while (i < larr.length && j < rarr.length) {
            if (larr[i] < rarr[j])
                arr[k] =larr[i++];
            else
                arr[k] = rarr[j++];
            k++ ;
        }

        while (i < larr.length) {
            arr[k++] =larr[i++];
        }
        while (j < rarr.length) {
            arr[k++] = rarr[j++];
        }

    }
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }
}
