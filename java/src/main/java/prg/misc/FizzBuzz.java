package prg;

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.function.Predicate;

public class FizzBuzz {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here


//        Scanner s = new Scanner(System.in);
//        String input = s.nextLine();
        String input = "3 15";
        String[] nums = input.trim().split(" ");

//        int numOfTc = Integer.valueOf(input.trim());

        for (int i = 0 ; i < nums.length; i++) {
            printFizzBuzz2(Integer.valueOf(nums[i].trim()));
        }
    }

    public static void printFizzBuzz(int num) {
        System.out.println("=============================");
        for (int i = 1; i <= num ; i++ ) {
            if ( i % 15 == 0 ) {
                System.out.println("FizzBuzz");
            } else {
                if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }
        }
    }

    public static void printFizzBuzz2(int num) {
        System.out.println("=============================");
        Predicate<Integer> divisibleBy15 = i -> i % 15 == 0;
        Predicate<Integer> divisibleBy3 = i -> i % 3 == 0;
        Predicate<Integer> divisibleBy5 = i -> i % 5 == 0;
        for (int i = 1; i <= num ; i++ ) {
            if (divisibleBy15.test(i) )
                System.out.println("FizzBuzz");
            else if (divisibleBy3.test(i))
                System.out.println("Fizz");
            else if (divisibleBy5.test(i))
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

}
