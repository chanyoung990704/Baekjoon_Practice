import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;

    // 세그먼트 트리
    static class SegmentTree{
        long[] tree, lazy;

        // 트리 빌드
        public SegmentTree(long[] arr) {
            int n = arr.length;
            tree = new long[4 * n];
            lazy = new long[4 * n];

            build(arr,1, 0, n - 1);
        }

        private void build(long[] arr, int node, int start, int end) {
            // basecase
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            // 분할
            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        // 지연전파
        private void push(int node, int start, int end) {
            if (lazy[node] != 0) {
                // 구간 길이
                int len = end - start + 1;
                long val = lazy[node];

                // 본인 값 갱신
                tree[node] += len * val;

                // 자식 전파
                if (start != end) {
                    lazy[node * 2] += val;
                    lazy[node * 2 + 1] += val;
                }
                lazy[node] = 0;
            }
        }

        // 업데이트
        private void update(int node, int start, int end, int left, int right, long val) {
            push(node, start, end);

            // 노드 구간이 쿼리 구간 밖
            if (end < left || right < start) {
                return;
            }
            // 구간 찾은 경우
            if (left <= start && end <= right) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, left, right, val);
            update(node * 2 + 1, mid + 1, end, left, right, val);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        // 쿼리
        private long query(int node, int start, int end, int left, int right) {
            push(node, start, end);

            // 노드 구간이 쿼리 구간 밖
            if (end < left || right < start) {
                return 0L;
            }

            // 구간 찾은 경우
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
        long[] arr = Arrays.stream(br.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();

        SegmentTree tree = new SegmentTree(arr);

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        while (Q-- > 0) {
            int[] query = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            if (query[0] == 1) {
                // 구간 업데이트
                tree.update(1, 0, N - 1, query[1] - 1, query[2] - 1, query[3]);
            }

            if (query[0] == 2) {
                sb.append(tree.query(1, 0, N - 1, query[1] - 1, query[1] - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
