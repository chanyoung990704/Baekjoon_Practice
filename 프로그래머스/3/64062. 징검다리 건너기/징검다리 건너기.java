class Solution {
    int[] tree;

    public int solution(int[] stones, int k) {
        int n = stones.length;
        tree = new int[n * 4];
        build(stones, 1, 0, n - 1);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            answer = Math.min(answer, query(1, 0, n - 1, i, i + k - 1));
        }
        return answer;
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, node * 2, start, mid);
        build(arr, node * 2 + 1, mid + 1, end);
        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Math.max(query(node * 2, start, mid, left, right),
                        query(node * 2 + 1, mid + 1, end, left, right));
    }
}