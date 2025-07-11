import java.io.*;
import java.util.*;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NQ = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NQ[0];
        int Q = NQ[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tree = new long[4 * N];
        initTree(nums, 0, N - 1, 1);

        while (Q-- > 0) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(query[0] > query[1]) {
                int temp = query[0];
                query[0] = query[1];
                query[1] = temp;
            }
            System.out.println(printQuery(1, 0, N-1, query[0] - 1, query[1] - 1));
            updateTree(1, 0, N-1, query[2] - 1, query[3]);
        }
    }

    private static long updateTree(int idx, int lo, int hi, int numIdx, int val) {
        if (numIdx < lo || numIdx > hi) {
            return tree[idx];
        }
        if (lo == hi) {
            return tree[idx] = val;
        }
        int mid = lo + (hi - lo) / 2;
        long leftSum = updateTree(2 * idx, lo, mid, numIdx, val);
        long rightSum = updateTree(2 * idx + 1, mid + 1, hi, numIdx, val);
        return tree[idx] = leftSum + rightSum;
    }

    private static long printQuery(int idx, int lo, int hi, int queryL, int queryR) {
        if (hi < queryL || lo > queryR) {
            return 0L;
        }
        if (queryL <= lo && hi <= queryR) {
            return tree[idx];
        }
        int mid = lo + (hi - lo) / 2;
        return printQuery(2 * idx, lo, mid, queryL, queryR)
                + printQuery(2 * idx + 1, mid + 1, hi, queryL, queryR);
    }

    private static long initTree(int[] nums, int lo, int hi, int idx) {
        if (lo == hi) {
            return tree[idx] = nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        return tree[idx] = initTree(nums, lo, mid, 2 * idx) + initTree(nums, mid + 1, hi, 2 * idx + 1);
    }
}
