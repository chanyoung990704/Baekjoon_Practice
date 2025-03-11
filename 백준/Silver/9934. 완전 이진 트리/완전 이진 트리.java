

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Node{
        int idx;
        Node left = null;
        Node right = null;

        Node(int idx){
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.valueOf(br.readLine());
        int k = K;

        Node root = new Node(0);
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);

        while (K-- > 1) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                // 자식 노드 추가
                Node cur = dq.poll();
                Node left = new Node(0);
                Node right = new Node(0);
                cur.left = left;
                cur.right = right;
                dq.offer(left);
                dq.offer(right);
            }
        }

        int[] idx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[]{0};

        traversal(root, idx, cnt);

        dq = new ArrayDeque<>();
        dq.offer(root);
        for (int i = 0; i < k; i++) {
            int size = dq.size();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++){
                Node cur = dq.poll();
                sb.append(cur.idx).append(" ");
                if(cur.left != null && cur.right != null){
                    dq.offer(cur.left);
                    dq.offer(cur.right);
                }
            }
            System.out.println(sb.toString().trim());
        }

    }

    private static void traversal(Node cur, int[] idx, int[] cnt) {
        // 왼쪽 끝까지 내려가기
        if(cur.left != null) {
            traversal(cur.left, idx, cnt);
        }

        cur.idx = idx[cnt[0]];
        cnt[0]++;

        if(cur.right != null) {
            traversal(cur.right, idx, cnt);
        }
    }
}
