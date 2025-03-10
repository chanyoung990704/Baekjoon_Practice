

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.valueOf(br.readLine());

            Map<Character, List<Integer>> map = new HashMap<>();

            for(int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }

            // 어떤 문자를 정확히 K개 포함 && 짧은 문자열
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                List<Integer> value = entry.getValue();
                if (value.size() < K) {
                    continue;
                }
                for(int i = 0 ; i + K <= value.size(); i++) {
                    min = Math.min(min, value.get(i + K - 1) - value.get(i) + 1);
                    max = Math.max(max, value.get(i + K - 1) - value.get(i) + 1);
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(min + " " + max);

        }

    }
}
