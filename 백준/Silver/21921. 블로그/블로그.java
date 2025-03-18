

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 지난 일수 N 기간 X
        int[] NX = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NX[0];
        int X = NX[1];

        // N일 접속량
        int[] users = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 투포인터
        int lo = 0;
        int hi = 0;

        int sum = 0;
        int max = -1;
        int cnt = 0;

        while (hi < users.length) {
            sum += users[hi];

            // X일 초과 제외
            while (hi - lo + 1 > X){
                sum -= users[lo];
                lo++;
            }

            // 최대 갱신
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }

            hi++;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);

    }

}
