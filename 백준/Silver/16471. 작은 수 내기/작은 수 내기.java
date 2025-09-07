import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        List<Integer> juyeon =  Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> boss =  Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        // TreeMap변환
        TreeMap<Integer, Long> treeMap = juyeon.stream()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()));

        // 순회
        int cnt = 0;
        for (int n : boss) {
            // 최소 키
            int min = treeMap.firstKey();

            // 이길 수 없는 경우
            if (min >= n) {
                int max =  treeMap.lastKey();
                treeMap.put(max, treeMap.get(max) - 1);
                if (treeMap.get(max) == 0) {
                    treeMap.remove(max);
                }
            }else{
                // 타겟 미만의 키 찾기
                int best = treeMap.lowerKey(n);
                treeMap.put(best, treeMap.get(best) - 1);
                if(treeMap.get(best) == 0) {
                    treeMap.remove(best);
                }

                cnt++;
            }
        }

        System.out.println(cnt >= (N + 1) / 2 ? "YES" : "NO");
    }
}
