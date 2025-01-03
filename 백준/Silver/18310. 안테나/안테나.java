import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        int idx = (list.size() - 1) / 2;

        System.out.println(list.get(idx));

        

        br.close();

    }
}
