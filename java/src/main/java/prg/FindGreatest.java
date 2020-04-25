package prg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindGreatest {

    public static void main(String[] args) {
        List<Integer> input = List.of(2, 12, 9, 3);
        System.out.println(input + " MAX=> " + findGreatest(input));
        System.out.println(input + " IIndMAX=> " + findSecondGreatest(input));
    }

    private static int findGreatest(List<Integer> input) {
        // approach 1
       int grt = Integer.MIN_VALUE;
        for (int e : input) {
            if (e > grt)
                grt = e;
        }
        return grt;

        // approach 2
//        return input.stream().max(Comparator.naturalOrder());

        // approach 3

//        return input.stream().reduce(Integer.MIN_VALUE, (l, r) -> l > r ? l : r);
    }

    private static int findSecondGreatest(List<Integer> input) {
        int gtr = Integer.MIN_VALUE;
        int sgtr = Integer.MIN_VALUE;

        for (int i : input) {
            if (i > gtr) {
                sgtr = gtr;
                gtr = i;
            }
            else if( i > sgtr && i < gtr )
                sgtr = i;
        }
//        List<Integer> sorted = input.stream().sorted().collect(Collectors.toList());
//        return sorted.get(sorted.size() - 2);
        return sgtr;
    }
}
