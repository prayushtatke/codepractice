package prg.array;

public class AlternateParityPermutation {
    public static void main(String[] args) {

    }

    public static boolean checkParity(int n1, int n2) {
        if( n1 == n2 )
            return false;

        if ( n1 % 2 == 0 && n2 % 2 != 0 )
            return true;

        if (n1 % 2 != 0 && n2 % 2 == 0 )
            return true ;

        return false;
    }
}
