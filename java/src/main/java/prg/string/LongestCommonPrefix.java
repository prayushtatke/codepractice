package prg.string;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
//        String [] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 )
            return "";

        if (strs.length == 1)
            return strs[0];

        String seed = lcp(strs[0],strs[1]);
        // if for any two string comparison the max LCP is "" then, that means there is no common prefix in all string.
        String maxLcp = seed;
        for (int i = 1 ; i < strs.length; i++){
            String lcp = lcp(seed, strs[i]);

            if (lcp.equals(""))
                return "";

            if ( lcp.length() <= maxLcp.length() )
                maxLcp = lcp;

        }
        return maxLcp;
    }

    private static String lcp(String s1, String s2) {
        if (s1.equals(s2))
            return s1;

        int ei = -1;
        int min = s1.length() <= s2.length() ? s1.length() : s2.length();

        for (int i = 0 ; i < min ; i++ ) {
            if (s1.charAt(i) == s2.charAt(i))
                ei++;
            else
                break;
        }

        if (ei == -1 )
            return "";

        return s1.substring(0, ei+1);
    }

    public static String longestCommonPrefix_1(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minStr = null;
        for (int i = 0 ; i < strs.length ; i ++){
            if (strs[i].length() < min ) {}
            min = strs[i].length() ;
            minStr = strs[i];
        }

        List<Character> chars = new ArrayList<>();

        for (int i = 0 ; i < minStr.length() ; i++) {
            boolean match = true;
            char iChar = minStr.charAt(i);
            for (int j = 0 ; j < strs.length ; j++ ) {
                match = match && iChar == strs[j].charAt(i) ;
            }
            if ( match )
                chars.add(iChar);
            else
                break;
        }

        if (chars.isEmpty())
            return "";

        StringBuilder builder = new StringBuilder(chars.size());
        for(Character ch: chars)
            builder.append(ch);

        return builder.toString();
    }


}
