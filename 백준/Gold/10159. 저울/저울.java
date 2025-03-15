

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // 플루이드 워셜

        for (int i = 0; i < M; i++) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = ab[0];
            int b = ab[1];

            dist[a][b] = 1;
        }

        for(int i = 1; i < N + 1; i++) {
            for(int a = 1; a < N + 1; a++) {
                for(int b = 1 ; b < N + 1; b++) {
                    if (dist[a][i] != Integer.MAX_VALUE && dist[i][b] != Integer.MAX_VALUE) {
                        dist[a][b] = Math.min(dist[a][b], dist[a][i] + dist[i][b]);
                    }
                }
            }
        }

        for(int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for(int j = 1 ; j < N + 1; j++) {
                if (dist[i][j] == Integer.MAX_VALUE && dist[j][i] == Integer.MAX_VALUE) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
