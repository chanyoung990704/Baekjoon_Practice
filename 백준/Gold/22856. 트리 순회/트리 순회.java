

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Node{

        int idx;
        Node left, right;

        Node(int idx){
            this.idx = idx;
        }
    }

    static Map<Integer, Integer> parents;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 개수 N
        int N = Integer.valueOf(br.readLine());

        // 노드 자식 관계
        nodes = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            nodes.add(new Node(i));
        }

        // 부모 매핑
        parents = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int l = input[1];
            int r = input[2];
            if(l != -1) {
                nodes.get(a).left = nodes.get(l);
                parents.put(l, a);
            }
            if(r != -1) {
                nodes.get(a).right = nodes.get(r);
                parents.put(r, a);
            }
        }

        // 일반 중위 순회
        List<Integer> dist = new ArrayList<>();
        nodeSearch(nodes.get(1), dist);

        // 종료 인덱스
        int fin = dist.get(dist.size() - 1);

        List<Integer> dist2 = new ArrayList<>();
        nodeSearch2(nodes.get(1), dist2, new boolean[N + 1], fin);

        System.out.println(dist2.size() - 1);

    }

    private static void nodeSearch2(Node node, List<Integer> dist2, boolean[] booleans, int fin) {
        // 현재 방문
        booleans[node.idx] = true;
        dist2.add(node.idx);
        // 왼쪽 존재 및 방문 안했으면 이동
        if(node.left != null && !booleans[node.left.idx]){
            nodeSearch2(node.left, dist2, booleans, fin);
        }
        // 그렇지 않고 오른쪽
        else if(node.right != null && !booleans[node.right.idx]){
            nodeSearch2(node.right, dist2, booleans, fin);
        } else if (node.idx == fin) {
            return;
        }else{
            // 부모 존재하면
            if(parents.containsKey(node.idx)){
                nodeSearch2(nodes.get(parents.get(node.idx)), dist2, booleans, fin);
            }
        }
        return;
    }

    private static void nodeSearch(Node node, List<Integer> dist) {

        // 가장 왼쪽
        if(node.left != null) {
            nodeSearch(node.left, dist);
        }
        dist.add(node.idx);
        if(node.right != null) {
            nodeSearch(node.right, dist);
        }
    }
}
