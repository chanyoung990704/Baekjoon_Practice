

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            times[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 일찍 끝나는 순서로 정렬
        Arrays.sort(times, (a, b) ->{
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int start = times[0][0];
        int end = times[0][1];
        int cnt = 1;

        for(int i = 1; i < N; i++) {
            int nextStart = times[i][0];
            int nextEnd = times[i][1];

            if (nextStart >= end) {
                cnt++;
                start = nextStart;
                end = nextEnd;
            }
        }

        System.out.println(cnt);
    }
}
