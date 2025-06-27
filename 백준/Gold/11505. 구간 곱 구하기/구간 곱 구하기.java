import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static long[] tree;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NKM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NKM[0];
        int K = NKM[1];
        int M = NKM[2];

        tree = new long[4*N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        setTree(arr, 1, 0, N-1);

        for(int i = 0 ; i < M + K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 1) {
                int arrIDx = input[1]-1;
                arr[arrIDx] = input[2];

                updateTree(1, arrIDx, 0, N-1, input[2]);
            } else {
                System.out.println(calTree(1, 0, N-1, input[1]-1, input[2]-1));
            }
        }
    }

    private static Long calTree(int idx, int lo, int hi, int qlo, int qhi) {
        // 범위 밖
        if(hi < qlo || qhi < lo) {
            return 1L;
        }
        if(qlo <= lo && hi <= qhi) {
            return tree[idx];
        }

        int mid = (lo + hi) / 2;
        return (calTree(idx*2, lo, mid, qlo, qhi) * calTree(idx*2+1, mid+1, hi, qlo, qhi)) % MOD;
    }

    private static void updateTree(int treeIdx, int arrIdx, int lo, int hi, int val) {
        if(arrIdx < lo || hi < arrIdx) {
            return;
        }

        if(lo == hi) {
            tree[treeIdx] = val;
            return;
        }

        int mid = (lo + hi) / 2;
        if(arrIdx <= mid) {
            updateTree(treeIdx*2, arrIdx, lo, mid, val);
        } else {
            updateTree(treeIdx * 2 + 1, arrIdx, mid + 1, hi, val);
        }

        tree[treeIdx] = (tree[treeIdx*2] * tree[treeIdx*2+1]) % MOD;
    }

    private static long setTree(int[] arr, int idx, int lo, int hi) {
        if(lo == hi) {
            return tree[idx] = arr[lo];
        }

        int mid = (lo + hi) / 2;
        return tree[idx] = (setTree(arr, idx*2, lo, mid) * setTree(arr, idx*2+1, mid+1, hi)) % MOD;
    }
}
