import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,M;

    static class Tree{
        long[] tree_min, tree_max;

        Tree(long[] arr) {
            int len = arr.length;
            tree_max = new long[len * 4];
            tree_min = new long[len * 4];
            build(arr, 1, 0, len - 1);
        }

        public void build(long[] arr, int node, int start, int end) {
            // basecase
            if (start == end) {
                tree_max[node] = arr[start];
                tree_min[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);

            // 최대, 최소
            tree_min[node] = Math.min(tree_min[node * 2], tree_min[node * 2 + 1]);
            tree_max[node] = Math.max(tree_max[node * 2], tree_max[node * 2 + 1]);
        }

        public long queryMAX(int node, int start, int end, int left, int right) {
            // 영역 밖
            if (end < left || right < start) {
                return Long.MIN_VALUE;
            }

            // 쿼리 범위 안
            if (left <= start && end <= right) {
                return tree_max[node];
            }

            int mid = (start + end) / 2;
            return Math.max(queryMAX(node * 2, start, mid, left, right), queryMAX(node * 2 + 1, mid + 1, end, left, right));
        }

        public long queryMIN(int node, int start, int end, int left, int right) {
            // 영역 밖
            if (end < left || right < start) {
                return Long.MAX_VALUE;
            }

            // 쿼리 범위 안
            if (left <= start && end <= right) {
                return tree_min[node];
            }

            int mid = (start + end) / 2;
            return Math.min(queryMIN(node * 2, start, mid, left, right), queryMIN(node * 2 + 1, mid + 1, end, left, right));
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Tree tree = new Tree(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(tree.queryMIN(1, 0, N - 1, left-1, right-1)).append(" ").append(tree.queryMAX(1, 0, N - 1, left-1, right-1)).append("\n");
        }

        System.out.println(sb);
    }
}
