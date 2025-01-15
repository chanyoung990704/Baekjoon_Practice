import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());        

        // 각 구간 별 길이
        List<Integer> dist = new ArrayList<>();
        for(int i = 1 ; i < list.size() ; i++){
            dist.add(list.get(i) - list.get(i - 1));
        }

        dist.sort(Comparator.reverseOrder());

        long total = 0;
        for(int i = K - 1 ; i < dist.size() ; i++){
            total += dist.get(i);
        }

        System.out.println(total);
    }
}
