

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] dist = new int[n + 1][n + 1];
        for(int i = 0 ; i < n + 1; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            int cost = input[2];
            if (dist[x][y] > cost) {
                dist[x][y] = cost;
            }
            if(dist[y][x] > cost){
                dist[y][x] = cost;
            }
        }

        int[][] next = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                next[i][j] = j;
            }
        }

        // 플루이드 워셜
        for(int i = 1 ; i < n + 1; i++){
            for(int a = 1 ; a < n + 1; a++){
                for(int b =1 ; b < n + 1; b++){
                    // 경로 존재
                    if(dist[a][i] != Integer.MAX_VALUE && dist[i][b] != Integer.MAX_VALUE){
                        if(dist[a][b] > dist[a][i] + dist[i][b]){
                            dist[a][b] = dist[a][i] + dist[i][b];
                            next[a][b] = next[a][i];
                        }
                    }
                }
            }
        }

        for(int i = 1 ; i < n + 1; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1 ; j < n + 1; j++){
                if(i == j){
                    sb.append("-");
                }else{
                    sb.append(next[i][j]);
                }
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
