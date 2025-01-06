import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] levels = br.readLine().split(" ");

        Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            List<Integer> levelTime = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            int level = levelTime.get(0);
            int time = levelTime.get(1);

            m.computeIfAbsent(level, key -> new PriorityQueue<>()).offer(time);
        }

        int totalTime = 0;
        for(int i = 0 ; i < 5 ; i++){
            int curLevel = i + 1;
            int prev = 0;
            for(int j = 0 ; j < Integer.valueOf(levels[i]); j++){
                int t = m.get(curLevel).poll();
                if(prev != 0){
                    totalTime += t - prev;
                }
                totalTime += t;
                prev = t;
            }
            
            if(i != 4)
                totalTime += 60;
        }

        System.out.println(totalTime);

    }
}
