import java.io.*;
import java.util.*;

public class Main {

    static long[] segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N  = NM[0];
        int M =  NM[1];

        int[] arr =  new int[N];
        segTree = new long[4 * N];


        for (int k = 0; k < M; k++) {
            int[] op =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int o = op[0];
            int i = op[1];
            int j = op[2];

            if(o == 0 && i > j){
                int tmp = i;
                i = j;
                j = tmp;
            }

            if (o == 0) {
                //  sum
                System.out.println(sum(1, 1, N, i, j));
            } else if (o == 1) {
                // modify
                modify(1, 1, N, i, j);
            }

        }
    }

    private static long sum(int n, int lo, int hi, int ql, int qr) {
        //  impossible
        if(hi < ql || lo > qr){
            return 0;
        }

        // include
        if(ql <= lo && hi <= qr){
            return segTree[n];
        }

        int mid =  lo + (hi - lo)/2;
        return sum(2 * n, lo, mid, ql, qr) + sum(2*n + 1, mid + 1, hi, ql, qr);
    }

    private static long modify(int n, int lo, int hi, int idx, int val) {
        // basecase
        if (lo == hi) {
            return segTree[n] = val;
        }

        int mid =  lo + (hi - lo) / 2;

        if(idx <= mid){
            return segTree[n] = modify(2 *n, lo, mid, idx, val) + segTree[2 * n+1];
        }else{
            return segTree[n] = modify(2 * n + 1, mid+1,  hi, idx, val) + segTree[2 * n];
        }
    }
}
