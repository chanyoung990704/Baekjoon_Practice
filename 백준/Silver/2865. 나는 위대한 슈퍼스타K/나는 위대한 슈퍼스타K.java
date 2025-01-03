import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
        List<Integer> NMK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NMK.get(0);
        int M = NMK.get(1);
        int K = NMK.get(2);

        Map<Integer, Double> map = new HashMap<>();
        for(int i = 0 ; i < M ; i++){
            String[] parsed = br.readLine().split(" ");
            for(int j = 0 ; j < parsed.length ; j += 2){
                int idx = Integer.valueOf(parsed[j]);
                Double val = Double.valueOf(parsed[j + 1]);
                map.put(idx, Math.max(map.getOrDefault(idx, 0.0), val));
            }
        }

        List<Double> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        list = list.subList(0, 0 + K);

        double total = 0.0;
        for(double val : list) total += val;

        System.out.printf("%.1f\n", total);

        br.close();
    }
}
