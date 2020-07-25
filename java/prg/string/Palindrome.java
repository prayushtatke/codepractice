package prg.string;

public class Palindrome {
    public static void main(String[] args) {
        String s = "ababa";
        System.out.println("Is '"+s+"' a Palindrome: "+isPalindrome(s));
        String s2 = "babad";
        System.out.println("LPS: "+longestPalindrome(s2));


    }

    public static String longestPalindrome(String str) {
        if (str.isEmpty())
            return "";

        if (str.length() == 1)
            return str;

        String lps = str.substring(0,1);
        for (int i = 0 ; i < str.length() -1 ; i++) {
            for (int j = i+1 ; j < str.length() ; j++ ) {
                String ps = str.substring(i, j+1);
                System.out.println(ps);
                if( isPalindrome(ps) ) {
                    if ( ps.length() >= lps.length() )
                        lps = ps;
                }
            }
        }
        return lps;
    }

    private static boolean isPalindrome(String str) {
        char [] c = str.toCharArray();

        int s = 0;
        int e = c.length -1;

        while ( s<=e ) {
            if (c[s] != c[e])
                return false;
            s++;
            e--;
        }

        return true;
    }
}
