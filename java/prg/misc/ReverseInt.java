package prg.misc;

import java.util.List;
import java.util.ArrayList;

/*
Given a 32-bit signed integer, reverse digits of an integer.
*/

public class ReverseInt {
    public static void main(String[] args) {
        ReverseInt test = new ReverseInt();
//        System.out.println("123 => " + test.reverse(-153423646));
//        System.out.println("-420 => " + test.reverse(-420));
//        System.out.println("243243 => " + test.reverse(24324368));
        System.out.println(isPalindrome(8998));

    }
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;

        int sign = x < 0 ? -1 : 1;
        x = sign * x;
        List<Integer> l = new ArrayList<>();
        while (x != 0) {
            l.add(x % 10);
            x /= 10;
        }

        long res = 0;
        for (int i = 0, j = l.size() - 1; i < l.size(); i++, j--) {
            res += l.get(i) * Math.pow(10, j);
            if (res > Integer.MAX_VALUE)
                return 0;
        }
        return sign * (int)res;
    }

    public int reverse_1(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

    public int reverse_2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
                return 0;

            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int x = n;
        while ( x != 0 ) {
            reverse = 10*reverse + x % 10;
            x = x/10;
            if ( reverse >= x )
                break;
        }
        return reverse == x || reverse/10 == x ;
    }

}
