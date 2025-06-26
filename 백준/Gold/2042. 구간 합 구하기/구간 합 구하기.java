import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NMK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMK[0];
        int M = NMK[1];
        int K = NMK[2];
        tree = new long[4 * N];

        List<Long> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        initTree(list, 1, 0, N - 1);

        for(int i = 0 ; i < M + K; i++) {
            long[] abc = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if(abc[0] == 1) {
                // 업데이트
                int idx = (int)(abc[1] - 1);
                long diff = abc[2] - list.get(idx);
                list.set(idx, Long.valueOf(abc[2]));
                update(1, 0, N - 1, idx, diff);
            }
            else if(abc[0] == 2) {
                // 더하기
                System.out.println(sum(1, 0, N - 1, (int)(abc[1] - 1), (int)(abc[2] - 1)));
            }
        }
    }

    private static void update(int i, int lo, int hi, int idx, long diff) {
        if(idx < lo || idx > hi) {
            return;
        }

        tree[i] += diff;
        if(lo != hi) {
            int mid = (lo + hi) / 2;
            update(i * 2, lo, mid, idx, diff);
            update(i * 2 + 1, mid + 1, hi, idx, diff);
        }
    }

    private static Long sum(int i, int lo, int hi, int leftP, int rightP) {
        // 범위 밖이면
        if(leftP > hi || rightP < lo) {
            return 0L;
        }

        // 범위 포함이면
        if(leftP <= lo && hi <= rightP) {
            return tree[i];
        }

        int mid = (lo + hi) / 2;
        return sum(i * 2, lo, mid, leftP, rightP) + sum(i * 2 + 1, mid + 1, hi, leftP, rightP);
    }

    private static Long initTree(List<Long> list, int i, int lo, int hi) {

        // leaf
        if(lo == hi){
            return tree[i] = list.get(lo);
        }

        int mid = (lo + hi) / 2;
        return tree[i] = initTree(list, i * 2, lo, mid) + initTree(list, i * 2 + 1, mid + 1, hi);
    }
}
