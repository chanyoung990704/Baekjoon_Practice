import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int dir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> PN = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList()); 
        
        int P = PN.get(0);
        int N = PN.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());


        int idx = 0;
        while (P < 200 && idx < list.size()) {
            P += list.get(idx++);
        }

        System.out.println(idx);

    }    
}
