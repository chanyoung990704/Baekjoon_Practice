import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        int idx = 0;
        List<Integer> list = IntStream.range(1, N + 1)
        .mapToObj(Integer::valueOf).collect(Collectors.toList());

        List<Integer> res = new ArrayList<>();

        while (!list.isEmpty()) {
            if(idx >= list.size()) idx = 0;
            int cnt = 1;
            while (cnt < K) {
                cnt++;
                idx++;
                if(idx >= list.size()) idx = 0;
            }
            res.add(list.remove(idx));
        }

        System.out.println(
            res.stream().map(String::valueOf)
            .collect(Collectors.joining(", ", "<", ">"))
        );

    }

}