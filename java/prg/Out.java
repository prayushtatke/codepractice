package prg;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Out {

    public static void emptyln(){
        System.out.println();
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static class Util {

        public static void sleepMins(long timeout ) {
            sleep(timeout, TimeUnit.MINUTES);
        }

        public static void sleepSecs(long timeout ) {
            sleep(timeout,TimeUnit.SECONDS);
        }

        public static void sleepMillis(long timeout ) {
            sleep(timeout,TimeUnit.MILLISECONDS);
        }


        public static void sleep(long timeout ,TimeUnit unit) {
            try {
                unit.sleep(timeout);
            } catch (InterruptedException ie) {

            }
        }

        public static void swap(int [] input,int left,int right) {
            if (left == right)
                return;

            // using a temp variable
    //        int temp;
    //        temp = input[left];
    //        input[left] = input[right];
    //        input[right] = temp;

            // using arithmatics operations
            input[left] = input[left] + input[right];
            input[right] = input[left] - input[right];
            input[left] = input[left] - input[right];

            // using Bitwise XOR
    //        input[left] = input[left] ^ input[right];
    //        input[right] = input[left] ^ input[right];
    //        input[left] = input[left] ^ input[right];

        }

        public static List<Integer> arrayAsList(int [] input) {
            return null;
        }
    }
}
