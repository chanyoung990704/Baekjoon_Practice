import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;
    static int[] ret = new int[2];
    static long sum = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lo = 0;
        int hi = N - 1;

        while (lo < hi) {
            long curSum = (long) arr[lo] + arr[hi];

            if (Math.abs(curSum) < sum) {
                sum = Math.abs(curSum);
                ret[0] = arr[lo];
                ret[1] = arr[hi];
            }

            if (curSum < 0) {
                lo++;
            } else if (curSum > 0) {
                hi--;
            } else {
                break;
            }
        }

        System.out.println(ret[0] + " " + ret[1]);
    }
}
