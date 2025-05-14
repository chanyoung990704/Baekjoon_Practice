import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8192);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] max = new int[3];
        int[] min = new int[3];

        int max0, max2, min0, min2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num0 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max[0] = min[0] = num0;
                max[1] = min[1] = num1;
                max[2] = min[2] = num2;
                continue;
            }

            // 최대 구하기
            max0 = max[0];
            max2 = max[2];

            max[0] = Math.max(max[0], max[1]) + num0;
            max[2] = Math.max(max[1], max[2]) + num2;
            max[1] = Math.max(Math.max(max0, max2), max[1]) + num1;

            // 최소 구하기
            min0 = min[0];
            min2 = min[2];

            min[0] = Math.min(min[0], min[1]) + num0;
            min[2] = Math.min(min[1], min[2]) + num2;
            min[1] = Math.min(Math.min(min0, min2), min[1]) + num1;
        }

        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
    }

}
