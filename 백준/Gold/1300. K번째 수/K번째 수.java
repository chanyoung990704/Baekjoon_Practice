import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k =  Integer.parseInt(br.readLine());

        int lo = 0;
        int hi = 1000000000;
        int res = 0;

        while (lo <= hi) {
            int mid =  lo + (hi - lo) / 2;
            int cnt = 0;
            // logic
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }

            if (cnt >= k) {
                res = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(res);
    }
}
