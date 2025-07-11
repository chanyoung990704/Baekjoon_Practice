import java.io.*;
import java.util.*;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NQ = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NQ[0];
        int Q = NQ[1];

        tree = new long[4 * N];

        for(int i = 0; i < Q; i++) {
            int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(q[0] == 1) {
                update(1, q[1] - 1, 0, N - 1, q[2]);
            } else {
                System.out.println(query(1, 0, N - 1, q[1] - 1, q[2] - 1));
            }
        }

    }

    private static void update(int idx, int date, int lo, int hi, long val) {
        if(date < lo || date > hi) {
            return;
        }
        if(lo == hi) {
            tree[idx] += val;
            return;
        }

        int mid = lo + (hi - lo) / 2;
        if(date <= mid) {
            update(2 * idx, date, lo, mid, val);
        } else {
            update(2 * idx + 1, date, mid + 1, hi, val);
        }

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    private static long query(int idx, int lo, int hi, int queryL, int queryR) {
        if(hi < queryL || lo > queryR) {
            return 0L;
        }

        if(lo >= queryL && hi <= queryR) {
            return tree[idx];
        }

        int mid = lo + (hi - lo) / 2;
        return query(2 * idx, lo, mid, queryL, queryR) + query(2 * idx + 1, mid + 1, hi, queryL, queryR);
    }

}
