package prg.string;

public class Anagrams {

    public static void main(String [] args) {
        String str1 = "helo";
        String str2 = "elohl";
        System.out.println("Are '"+str1 +"', '"+str2+"' anagram? "+checkAnagram(str1,str2));
    }

    // O(n)
    private static boolean checkAnagram(String str1,String str2) {
        if (str1.length() != str2.length())
            return false;

        char [] str1Arr = str1.toCharArray();
        char [] str2Arr = str2.toCharArray();

        int [] temp = new int[26];

        for(char c : str1Arr) {
            int indx = (int)c - 'a';
            temp[indx]++;
        }

        for(char c : str2Arr) {
            int indx = (int)c -'a';
            temp[indx]++;
        }

        for(int i : temp) {
            if (i % 2 != 0 ) return false;
        }

        return true;
    }

    // O(n^2)
    private static boolean checkAnagram_2(String str1,String str2) {
        if (str1.length() != str2.length())
            return false;

        char [] str1Arr = str1.toCharArray();
        char [] str2Arr = str2.toCharArray();

        for(char c : str1Arr) {
            int result = 0;
            int a = (int)c;
            for(char c2 : str2Arr) {
                result ^= (int)c;
            }
            if (result != 0)
                return false;
        }
        return true;
    }
}
