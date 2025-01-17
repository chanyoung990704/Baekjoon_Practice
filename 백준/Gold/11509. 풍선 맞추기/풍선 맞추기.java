import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;

        for(int i = 0 ; i < list.size() ; i++){
            int cur = list.get(i);
            // 현재 가능한 경우
            if(map.containsKey(cur)) {
                map.put(cur, Math.max(map.get(cur) - 1, 0));
                if(map.get(cur) == 0){
                    map.remove(cur);
                }
                map.put(cur - 1, map.getOrDefault(cur - 1, 0) + 1);
            }else{
                cnt++;
                map.put(cur - 1, map.getOrDefault(cur - 1, 0) + 1);
            }
        }
        System.out.println(cnt);
    }
}
