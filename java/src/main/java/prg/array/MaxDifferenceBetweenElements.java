package prg.array;

public class MaxDifferenceBetweenElements {

    public static void main(String[] args) {
        int [] a = {9,8,6,3,2};
        System.out.println( findMaxDiff(a));
    }

    // O(n)
    private static int findMaxDiff(int [] a) {
        int maxDiff = a[1] - a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - min;
            maxDiff = diff > maxDiff ? diff : maxDiff;
            min = a[i] < min ? a[i] : min;
        }
        return maxDiff;
    }

    // O(n^2)
    private static int findMaxDiff_2(int [] a) {
        int maxDiff = -1;
        int diff = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    diff = a[i] - a[j];
                    if (diff > maxDiff)
                        maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }



}
