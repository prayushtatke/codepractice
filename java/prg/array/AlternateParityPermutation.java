package prg.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
  A permutation of [n] = {1, 2, . . . , n} will be called a parity alternating permutation (PAP)
  if its entries assume even and odd integers alternately, such as 72581634.
**/
public class AlternateParityPermutation {
    public static void main(String[] args) {
        int [] arr = { 7, 2, 5, 8, 1, 6, 3, 4 };
        System.out.println(String.format("isParityPermutation: %s -> %s",
            Arrays.toString(arr), isParityPermutation(arr)));

        int [] arr2 = { 7, 2, 5, 8, 1, 9, 3, 4 };
        System.out.println(String.format("isParityPermutation: %s -> %s",
            Arrays.toString(arr), isParityPermutation(arr2)));

    }

    public static boolean isParityPermutation(int [] arr) {
        boolean isParity = true ;
        for (int i = 0; i < arr.length - 1; i++) {
            isParity = isParity && checkParity(arr[i], arr[i+1]) ;
        }
        return isParity;
    }

    public static boolean checkParity(int n1, int n2) {
        if( n1 == n2 )
            return false;

        if ( n1 % 2 == 0 && n2 % 2 != 0 )
            return true;

        if (n1 % 2 != 0 && n2 % 2 == 0 )
            return true ;

        return false;
    }
}
