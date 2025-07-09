import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        List<Integer> arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        List<Long> prefixSum = new ArrayList<>();
        prefixSum.add(0L);
        for (int i = 0; i < N; i++) {
            prefixSum.add(prefixSum.get(i) + arr.get(i));
        }

        List<Long> modPrefixSum = prefixSum.stream().map(i -> ((i % M) + M) % M).collect(Collectors.toList());

        Map<Long, Integer> map = new HashMap<>();
        for(Long m : modPrefixSum) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        long res = 0;
        for(long v : map.values()) {
            if(v > 1){
                res += v * (v - 1) / 2;
            }
        }

        System.out.println(res);
    }
}
