import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> A = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        List<Integer> B = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
        int sum = 0;

        for(int i = 0 ; i < N ; i++) sum += (A.get(i) * B.get(i));

        System.out.println(sum);

        br.close();
    }
}