import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        // 2차원 행렬 누적합
        int[][] prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // 4중 반복문
        int ret = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .min()
                .orElse(Integer.MIN_VALUE);

        
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                // 시작점 i, j
                for (int k = i; k < prefixSum.length; k++) {
                    for (int h = j; h < prefixSum[0].length; h++) {
                        // 끝점 k, h

                        // 계산
                        int cur = prefixSum[k][h] - (prefixSum[i - 1][h] + prefixSum[k][j - 1]) + prefixSum[i - 1][j - 1];
                        ret = Math.max(ret, cur);
                    }
                }
            }
        }

        System.out.println(ret);
    }
}
