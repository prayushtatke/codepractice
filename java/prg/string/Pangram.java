package prg.string;

import java.util.BitSet;

public class Pangram {
    public static void main(String[] args) {
        String s = "We promptly judged antique ivory buckles for the prize";
//        String s = "";

        System.out.println(pangramsBitSet(s));

    }

    static String pangramsBitSet(String s) {
        BitSet bs = new BitSet(27);

        for(int c : s.toCharArray()) {
            int i = c >= 97 && c<=122 ? c - 32 : c;
            if ( ! bs.get(i) )
                bs.set(i);
        }

        // int totalSetBits = java.util.Arrays.stream(mask).map(Integer::bitCount).sum();
        if ( bs.cardinality() < 27)
            return "not pangram";
        else
            return "pangram";

    }
    static String pangrams(String s) {
        if (s.isEmpty() || s.length() < 26 )
            return "not pangram";

//        Integer.SIZE is 32
        int [] mask = new int[8];
        java.util.function.BiConsumer<int[],Integer> setBit = (a, i) -> {
            int q = i / 32 ;
            int r =  i % 32;
            int shift = r == 0 ? 31 : r -1;
            q = r == 0 ? q -1 : q;
            a[q] = a[q] | 1 << shift;
        };
        java.util.function.BiConsumer<int[],Integer> clearBit = (a, i) -> {
            int q = i / 32 ;
            int r =  i % 32;
            int shift = r == 0 ? 31 : r -1;
            q = r == 0 ? q -1 : q;
            a[q] = a[q] & ~(1 << shift);
        };
        java.util.function.BiPredicate<int[],Integer> isBitSet = (a,i) -> {
            int q = i / 32 ;
            int r =  i % 32;
            int shift = r == 0 ? 31 : r -1;
            q = r == 0 ? q -1 : q;
            return (a[q] & (1<<shift)) == 0;
        };

        for(char c : s.toCharArray()) {

            if( ! isBitSet.test(mask,(int)c) ) {
                setBit.accept(mask,(int)c);
            }
        }

        int totalSetBits = java.util.Arrays.stream(mask).map(Integer::bitCount).sum();
        if ( totalSetBits < 53)
            return "not pangram";
        else
            return "pangram";

    }
}
