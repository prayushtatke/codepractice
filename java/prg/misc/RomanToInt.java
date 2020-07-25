package prg.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static final Map<Character,Integer> romanIntMap;
    static {
        romanIntMap = new HashMap<>();
        romanIntMap.put('I',1);
        romanIntMap.put('V',5);
        romanIntMap.put('X',10);
        romanIntMap.put('L',50);
        romanIntMap.put('C',100);
        romanIntMap.put('D',500);
        romanIntMap.put('M',1000);

    }

    public static void main(String[] args) {
        System.out.println("III -> "+romanToInt("III"));
        System.out.println("IV -> "+romanToInt("IV"));
        System.out.println("IX -> "+romanToInt("IX"));
        System.out.println("LVIII -> "+romanToInt("LVIII"));
        System.out.println("MCMXCIV -> "+romanToInt("MCMXCIV"));



    }
    public static int romanToInt(String s) {
        char [] c = s.toCharArray();
        int sum = romanIntMap.get(c[0]);
        int prev = romanIntMap.get(c[0]);
        for (int i = 1 ; i < c.length ; i++ ) {
            int next = romanIntMap.get(c[i]);
            if ( prev >= next )
                sum += next;
            else
                sum += next - (2*prev);

            prev = next;

        }

        return sum;
    }
}
