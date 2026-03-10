import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] city;

    static List<int[]> chickens = new ArrayList<>(); // 치킨집 위치
    static List<int[]> houses = new ArrayList<>();

    static int min = 987654321;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            city[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if(city[i][j] == 2){
                    chickens.add(new int[]{i, j});
                }
                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(min);

    }

    private static void dfs(int start, int status) {
        // 최대 M개
        if (Integer.bitCount(status) == M) {
            calculate(status);
            return;
        }

        // 상태 갱신
        for (int i = start; i < chickens.size(); i++) {
            // 현재포함 된것은
            if((status >> i & 1) == 1){
                continue;
            }
            dfs(i+1,status | (1 << i));
        }
    }

    private static void calculate(int status) {
        int total = 0;
        // 집마다 반복
        for (int[] house : houses) {
            int cur = 987654321;
            int y = house[0], x = house[1];
            for (int i = 0; i < chickens.size(); i++) {
                if ((status >> i & 1) == 1) {
                    // 거리 계산
                    int[] chicken = chickens.get(i);
                    cur = Math.min(cur, Math.abs(chicken[0] - y) + Math.abs(chicken[1] - x));
                }
            }
            // 결과 갱신
            total += cur;
        }

        min = Math.min(min, total);
    }

}