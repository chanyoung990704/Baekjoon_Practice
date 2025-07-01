import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < N ;i ++) {
            int idx = i+1;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < arr.length ; j++) {
                if(arr[j] == 1){
                    dist[idx][j+1] = 1;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            dist[i][i] = 0;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int a = 1 ; a <= N ; a++){
                for(int b = 1; b <= N ; b++){
                    if(dist[a][i] != Integer.MAX_VALUE && dist[i][b] != Integer.MAX_VALUE && dist[a][b] > dist[a][i] + dist[i][b]){
                        dist[a][b] = dist[a][i] + dist[i][b];
                    }
                }
            }
        }

        int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(plan.length == 1) {
            System.out.println("YES");
            return;
        }

        int prev = plan[0];
        for(int i = 1 ; i < plan.length ; i++){
            if(dist[prev][plan[i]] == Integer.MAX_VALUE){
                System.out.println("NO");
                return;
            }
            prev = plan[i];
        }
        System.out.println("YES");

    }
}
