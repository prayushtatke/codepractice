package prg.array;

import prg.Util;

import java.util.Arrays;

public class ArrangeEvenOdd {
    public static void main(String[] args) {
        int [] input = {11, 3, 13, 15, 4, 5, 2, 6};
        System.out.println("Before : "+ Arrays.toString(input));
        arrangeEvenThenOdd(input);
        System.out.println("After : "+ Arrays.toString(input));
    }

    private static void arrangeEvenThenOdd(int [] input) {

        int leftHead = 0;
        int rightHead = input.length -1 ;

        while (leftHead < rightHead) {

            while ( leftHead < input.length && input[leftHead] % 2 == 0 )
                leftHead++;

            while (rightHead > 0 && input[rightHead] %2 == 1)
                rightHead--;

//            for (;leftHead < input.length && input[leftHead] % 2 == 0 ; leftHead++ ){}
//            for (;rightHead > 0 && input[rightHead] %2 == 1 ; rightHead-- ){}


            if (leftHead > rightHead)
                break;

            Util.swap(input,leftHead,rightHead);
            leftHead++;
            rightHead--;

//            if (input[leftHead] % 2 == 0 )
//                leftHead++;
//
//            if ( input[rightHead] %2 == 1 )
//                rightHead--;
//
//            if ( input [leftHead] % 2 == 1  && input[rightHead] % 2 == 0){
//                Util.swap(input,leftHead,rightHead);
//                leftHead++;
//                rightHead--;

            }


        }



}
