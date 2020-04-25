package prg.array;

public class FindPeakElement {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,6,5,4,3};

        System.out.println(findPeak(a));

    }

    private static int findPeak(int [] a) {
        return findPeak(a,0,a.length -1);
    }

    private static int findPeak(int [] a, int start, int end) {
        int mid = (start + end)/2;

        // terminal condition
        if ( a[mid] > a[mid+1] && a[mid -1] < a[mid] )
            return a[mid];

        if (a[mid -1] < a[mid] && a[mid] < a[mid+1])
            return findPeak(a, mid+1, end);

        if ( a[mid -1] > a[mid] && a[mid] > a[mid+1]  )
            return findPeak(a, start, mid -1);

        return -1;
    }
}
