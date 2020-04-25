package prg.array;

import java.util.Arrays;

/**
 * A left rotation operation on an array shifts each of the array's elements unit to the left.
 * Given an array of integers and a number, perform left rotations on the array.
 *
 *
 *  An array of integers .
 * An integer , the number of rotations.
 * e.g. [1 2 3 4 5] => after 4 left rotation => [5 1 2 3 4]

 */
public class RotateLeft {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println("Before: " + Arrays.toString(a));
        int [] rot = rotateLeft(a, 4);
        System.out.println("After: " + Arrays.toString(rot));

    }

    private static int[] rotateLeft(int[] a, int r) {
        int [] rot = new int[a.length];

        for (int i = a.length -1 ; i >= 0 ; i --) {
            int in = i >= r ? i - r : a.length - (r -i);
            rot[in] = a[i];
        }
        return rot;
    }

    static int[] rotateLeftRecursive(int[] a, int d) {
        int endIndex = a.length -1 ;
        java.util.stream.IntStream.range(0,d).forEach(i -> shiftLeft(a, a[endIndex], endIndex -1 ) );
        return a;
    }

    private static void shiftLeft (int [] a, int val, int toIndex  ) {
        if ( toIndex < 0  ) {
            a[a.length - 1] = val;
            return;
        }
        int v = a[toIndex];
        a[toIndex] = val;
        shiftLeft(a, v, toIndex -1 ) ;
    }

}
