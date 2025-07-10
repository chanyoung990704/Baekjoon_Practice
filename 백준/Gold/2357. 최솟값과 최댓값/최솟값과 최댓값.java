import java.io.*;
import java.util.*;

public class Main {

    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        minTree = new int[4 * N];
        maxTree = new int[4 * N];
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<int[]> sub = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            sub.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        initMinTree(arr, 1, 0, N - 1);
        initMaxTree(arr, 1, 0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int[] s : sub) {
            int left = s[0];
            int right = s[1];
            sb.append(minQuery(1, 0, N - 1, left - 1, right - 1) + " " + maxQuery(1, 0, N - 1, left - 1, right - 1) + "\n");
        }

        System.out.println(sb);

    }

    private static int initMinTree(int[] arr, int idx, int lo, int hi) {
        if(lo == hi){
            return minTree[idx] = arr[lo];
        }

        int mid = (lo + hi) / 2;
        int min = Math.min(initMinTree(arr, idx * 2, lo, mid), initMinTree(arr, idx * 2 + 1, mid + 1, hi));
        return minTree[idx] = min;
    }

    private static int minQuery(int idx, int lo, int hi, int left, int right) {
        if (right < lo || hi < left) {
            return Integer.MAX_VALUE;
        }

        if (left <= lo && hi <= right) {
            return minTree[idx];
        }

        int mid = (lo + hi) / 2;
        return Math.min(minQuery(idx * 2, lo, mid, left, right), minQuery(idx * 2 + 1, mid + 1, hi, left, right));
    }

    private static int initMaxTree(int[] arr, int idx, int lo, int hi) {
        if(lo == hi){
            return maxTree[idx] = arr[lo];
        }
        int mid = (lo + hi) / 2;
        int max = Math.max(initMaxTree(arr, idx * 2, lo, mid), initMaxTree(arr, idx * 2 + 1, mid + 1, hi));
        return maxTree[idx] = max;
    }

    private static int maxQuery(int idx, int lo, int hi, int left, int right) {
        if (right < lo || hi < left) {
            return Integer.MIN_VALUE;
        }
        if (left <= lo && hi <= right) {
            return maxTree[idx];
        }
        int mid = (lo + hi) / 2;
        return Math.max(maxQuery(idx * 2, lo, mid, left, right), maxQuery(idx * 2 + 1, mid + 1, hi, left, right));
    }

}
