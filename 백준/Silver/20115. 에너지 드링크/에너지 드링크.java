import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        double total = list.get(0);

        for(int i = 1 ; i < list.size() ; i++) total += (double) list.get(i) / 2;

        System.out.println(total);

        br.close();

    }
}
