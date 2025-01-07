import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N + M ; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue() == 2) res.add(e.getKey());
        }

        res.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(res.size() + "\n");
        for(String s : res) sb.append(s + "\n");

        System.out.println(sb.toString());
    }
}