import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            list.add(cur);
        }

        list.sort(Comparator.comparing((List<Integer> l) -> l.get(1)));

        int prev = list.get(0).get(1);
        int total = 0;
        for(int i = 1 ; i < list.size() ; i++) {
            int start = list.get(i).get(0);
            if(prev < start) {
                total += Math.abs(prev - start);
                prev = start;
            }
        }

        System.out.println(total);
        br.close();
    }
}
