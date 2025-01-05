import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.valueOf(br.readLine());
        String[] parsed = br.readLine().replaceAll("B+", "B")
        .replaceAll("R+", "R").split("");
        Map<String, Integer> map = new HashMap<>();
        for(String s : parsed) map.put(s, map.getOrDefault(s, 0) + 1);

        int min = Math.min(map.getOrDefault("B", 0),
        map.getOrDefault("R", 0));

        System.out.println(min + 1);


        br.close();

    }
}
