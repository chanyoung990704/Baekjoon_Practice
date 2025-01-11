import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] time = Arrays.stream(br.readLine().split(":"))
        .mapToInt(Integer::valueOf).toArray();

        int total = time[0] * 60 + time[1];

        Map<Integer, Integer> map = new HashMap<>();

        // 10분 부터
        while (total / 600 > 0) {
            map.put(600, map.getOrDefault(600, 0) + total / 600);
            total %= 600;
        }
        // 1분
        while (total / 60 > 0) {
            map.put(60, map.getOrDefault(60, 0) + total / 60);
            total %= 60;
        }       

        // 30초
        while (total / 30 > 0) {
            map.put(30, map.getOrDefault(30, 0) + total / 30);
            total %= 30;
        }
        // 10초
        while (total > 0) {
            map.put(10, map.getOrDefault(10, 0) + total / 10);
            total %= 10;
        }

        //
        int cnt = map.values().stream().mapToInt(Integer::valueOf).sum();

        if(!map.containsKey(30)) cnt++;

        System.out.println(cnt);
    }
}
