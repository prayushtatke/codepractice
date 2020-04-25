package prg.array;

public class QuickSort {
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quicksort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }

    public static void quicksort(int [] arr, int left, int right) {
        if (left < right) {
            int piv =  partition(arr,left,right);
            quicksort(arr, left, piv -1);
            quicksort(arr, piv+1, right);

        }
    }

    public static int partition(int [] arr,int left,int right) {
        int piv = arr[right];
        int i = left -1;

        for (int j = left ; j < right ; j++) {
            if ( arr[j] <= piv ) {
                i++;
                swap(arr, i,j );
            }
        }

        swap(arr, i+1, right);
        return i+1;
    }

    public static void swap(int [] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
