import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> nmr = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nmr.get(0);
        int m = nmr.get(1);
        int r = nmr.get(2);

        List<Integer> item = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());
        item.add(0, -1);

        // 플루이드 워셜
        int[][] dist = new int[n + 1][n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // 간선 입력
        for(int i = 0 ; i < r ; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            int f = list.get(0);
            int t = list.get(1);
            int d = list.get(2);
            dist[f][t] = Math.min(dist[f][t], d);
            dist[t][f] = Math.min(dist[t][f], d);
        }

        for(int i = 1 ; i < n + 1 ; i++){
            for(int a = 1 ; a < n + 1 ; a++){
                for(int b = 1 ; b < n + 1; b++){
                    if(dist[a][i] != Integer.MAX_VALUE && 
                    dist[i][b] != Integer.MAX_VALUE){
                        dist[a][b] = Math.min(dist[a][b], dist[a][i] + dist[i][b]);
                    }
                }
            }
        }

        int max = 0;

        for(int i = 1 ; i < n + 1; i++){
            int cur = 0;
            for(int j = 1 ; j < n + 1; j++){
                if(dist[i][j] <= m){
                    cur += item.get(j);
                }
            }
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}


