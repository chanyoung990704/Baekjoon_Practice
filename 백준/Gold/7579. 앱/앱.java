import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class App {
        int m;
        int c;

        public App() {
        }

        public App(int m, int c) {
            this.m = m;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<App> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new App());
        }

        for(int i = 0 ; i < N ; i++){
            int v = sc.nextInt();
            list.get(i).m = v;
        }

        for(int i = 0 ; i < N; i++){
            int v = sc.nextInt();
            list.get(i).c = v;
        }

        int sum = list.stream().mapToInt(x -> x.c).sum();
        int[][]dp = new int[N+1][sum+1];

        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j <= sum ; j++){
                dp[i][j] = dp[i-1][j];
                App cur = list.get(i-1);
                if(j >=cur.c){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - cur.c] + cur.m);
                }
            }
        }

        for(int i  = 0 ; i <= sum ; i++){
            if(dp[N][i] >= M){
                System.out.println(i);
                return;
            }
        }

    }
}
