import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,M, K;

    static class SegmentTree{
        long[] tree, lazy;
        int n;

        // 생성자
        SegmentTree(long[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            lazy = new long[4 * n];
            build(arr, 1, 0, n - 1);
        }

        private void build(long[] arr, int node, int start, int end) {
            // basecase
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        private void push(int node, int start, int end) {
            // 지연 로딩 메모리
            if (lazy[node] != 0) {
                // 자식으로 전파
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        private void updateRange(int node, int start, int end, int left, int right, long val) {
            // 기존 지연 로딩 값 적용
            push(node, start, end);
            if (left > end || right < start) {
                return;
            }
            if (left <= start && end <= right) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            updateRange(node * 2, start, mid, left, right, val);
            updateRange(node * 2 + 1, mid + 1, end, left, right, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        private long query(int node, int start, int end, int left, int right) {
            push(node, start, end);
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);

        }
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 입력으로 숫자 주어짐
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 만들기
        SegmentTree tree = new SegmentTree(arr);

        // M + K개의 명령어
        int cnt = M + K;
        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                tree.updateRange(1, 0, N - 1, b - 1, c - 1, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(tree.query(1, 0, N - 1, b - 1, c - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
