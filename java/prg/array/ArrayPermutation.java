package prg.array;

import java.util.Arrays;

public class ArrayPermutation {
    public static void main(String[] args) {
        permute(new int[]{ 1,2,3,4 });
    }

    public static void permute(int[] arr){
        permuteHelper(arr, 0);
    }

    private static void permuteHelper(int[] arr, int index) {
        //If we are at the last element - nothing left to permute
        if( index >= arr.length - 1 ) {
            //Print the array
//            System.out.println("index: "+index);
            System.out.println(Arrays.toString(arr));
            return;
        }

        for( int i = index; i < arr.length; i++ ) {
            //For each index in the sub array arr[index...end]
            //Swap the elements at indices index and i
//           System.out.println("before: index: "+index+", i: "+i+", arr: "+Arrays.toString(arr));

            swap(arr, index, i);
//            System.out.println("before: swapped: "+Arrays.toString(arr));

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1);

//            System.out.println("after: index: "+index+", i: "+i+", arr: "+Arrays.toString(arr));
            // Swap the elements back
            swap(arr,index,i);
//            System.out.println("after: swapped: "+Arrays.toString(arr));
        }
    }

    private static void swap(int [] arr, int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
