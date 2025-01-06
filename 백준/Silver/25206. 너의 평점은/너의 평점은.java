import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> m = new HashMap<>();
        m.put("A+", 4.5);
        m.put("A0", 4.0);
        m.put("B+", 3.5);
        m.put("B0", 3.0);
        m.put("C+", 2.5);
        m.put("C0", 2.0);
        m.put("D+", 1.5);
        m.put("D0", 1.0);
        m.put("F", 0.0);

        double sum = 0.0; // 
        double total = 0.0; // 학점의 총합

        for(int i = 0 ; i < 20 ; i++) {
            String[] s = br.readLine().split(" ");
            if(s[2].equals("P")) continue;
            total += Double.valueOf(s[1]);
            sum += (Double.valueOf(s[1]) * m.get(s[2]));
        }

        System.out.println(sum / total);
    }
}