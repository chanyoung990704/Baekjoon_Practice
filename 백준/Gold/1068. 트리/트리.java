import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Node{
        int idx;
        List<Node> children;

        public Node(int idx, List<Node> children) {
            this.idx = idx;
            this.children = children;
        }
    }

    static int leaf = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<Node> nodes = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            nodes.add(new Node(i, new ArrayList<>()));
        }

        List<Integer> parents =  Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int root = -1;
        for(int i = 0 ; i < N ; i++){
            if(parents.get(i) == -1){
                root = i;
                continue;
            }
            Node cur = nodes.get(i);
            Node parent = nodes.get(parents.get(i));
            parent.children.add(cur);
        }

        int del = Integer.valueOf(br.readLine());
        // 루트 지우는 경우
        if(del == root){
            System.out.println(0);
            return;
        }

        int delParent = parents.get(del);
        List<Node> renewList = nodes.get(delParent).children
                        .stream().filter(i -> i.idx != del)
                        .collect(Collectors.toList());
        nodes.get(delParent).children = renewList;

        seaching(root, nodes);
        System.out.println(leaf);
    }

    private static void seaching(int idx, List<Node> nodes) {
        Node cur = nodes.get(idx);
        if(cur.children.isEmpty()){
            leaf++;
            return;
        }

        for(Node child : cur.children){
            seaching(child.idx, nodes);
        }
    }
}
