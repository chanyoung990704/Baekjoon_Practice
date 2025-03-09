
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NML = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NML[0];
        int M = NML[1];
        int L = NML[2];

        List<Integer> roads = new ArrayList<>();
        if (N > 0) {
            roads = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                    .sorted().collect(Collectors.toList());
        }

        int lo = 1;
        int hi = L;
        int ret = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            if (N == 0) {
                cnt = (L - 1) / mid;
            }else{
                cnt = getCnt(roads.stream().mapToInt(Integer::valueOf).toArray(), mid, L);
            }

            if (cnt > M) {
                lo = mid + 1;
            }else{
                ret = mid;
                hi = mid - 1;
            }
        }

        System.out.println(ret);
    }

    private static int getCnt(int[] roads, int mid, int L) {
        int start = 0;
        int end = L;
        int cnt = 0;

        for (int i = 0; i < roads.length; i++) {
            if (i == 0) {
                cnt += (roads[i] - start - 1) / mid;
            }
            if(i == roads.length - 1) {
                cnt += (end - roads[i] - 1) / mid;
                continue;
            }
            cnt += (roads[i + 1] - roads[i] - 1) / mid;
        }

        return cnt;
    }
}
