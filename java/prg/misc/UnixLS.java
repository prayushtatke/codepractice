package prg.misc;

import java.io.File;

public class UnixLS {
    public static void main(String[] args) {

        System.exit(ls(args));
    }

    private static int ls(String... paths) {
        for(String path : paths) {

        }
return 1;
    }

    private int checkIfFileExist(File file) {
        if (file.exists())
            return 0;

        System.err.println(String.format("ls: cannot access '%s': No such file or directory",file.getName()));
        return 1;
    }
}
