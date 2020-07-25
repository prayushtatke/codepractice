package prg;/* Save this in a file called prg.Main.java to compile and test it */

/* Do not add a package declaration */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* You may add any imports here, if you wish, but only from the
   standard library */

public class Main {
    private static class Installation {
        String server;
        String swType;
        String swName;
        String swVersion;

        public Installation(String [] s) {
            this(s[0].trim(),s[1].trim(),s[2].trim(),s[3].trim());
        }

        public Installation(String server,String swType,String  swName,String swVersion) {
            this.server = server;
            this.swType = swType;
            this.swName = swName;
            this.swVersion = swVersion;
        }

        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s",server,swType,swName,swVersion);
        }
    }

    public static int processData(List<String> array) {

        // creating list of Installations, doing necessary String trimming once.
        List<Installation> installations = array.stream().map(s -> s.split(","))
                      .map(s -> new Installation(s))
                .collect(Collectors.toList());

        // calculating max or latest versions for each S/W.
        Map<String,String> maxVersions = installations.stream()
                                         .collect(
                                                  Collectors.toMap(i -> i.swName,
                                                                   i -> i.swVersion ,
                                                                    (v1,v2) -> getMaxVersion(v1, v2) )
                                                 );

        // filtering installations other than the latest version.
        Map<String,Set<Installation>> differentInstallation = new HashMap<>();
        installations.stream()
                     .filter(inst -> inst.swVersion != maxVersions.get(inst.swName))
                     .forEach(inst -> differentInstallation.computeIfAbsent(inst.swName, k ->new HashSet<>()).add(inst));

        // return the count of installations other than the latest, and number of installations more than or equal to 2.
        return (int)differentInstallation.values().stream().filter(s -> s.size() >=2 ).count();
    }

    public static String getMaxVersion(String v1, String v2) {
        if ( v1 == null && v2 != null )
            return v1;

        if ( v1 != null && v2 == null )
            return v2;

        if (v1 == null && v2 == null )
            throw new RuntimeException("No versions to compare");

        if (v1.equals(v2))
            return v1;

        String [] sa1 = v1.trim().split("\\.");
        String [] sa2 = v2.trim().split("\\.");

        int max = Math.max(sa1.length, sa2.length);
        for (int i = 0 ; i < max; i++) {
            int i1 = Integer.valueOf(sa1[i]);
            int i2 = Integer.valueOf(sa2[i]);

            if ( i1 > i2 )
                return v1;

            if ( i1 < i2 )
                return v2;
        }
        return v1;

    }

    public static void main (String[] args) {
        try {
            List<String> lines = Files.lines(Paths.get("input.txt")).collect(Collectors.toList());
            int count = processData(lines);
            System.out.println(count);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("output.txt"));
            bufferedWriter.write(""+count);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
