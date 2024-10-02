import java.util.*;
import java.util.stream.*;

class Solution {
    static class Node {
        final int x, y, idx;
        Node left, right;
        
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = IntStream.range(0, nodeinfo.length)
            .mapToObj(i -> new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1))
            .sorted(Comparator.comparing((Node n) -> n.y).reversed()
                              .thenComparing((Node n) -> n.x))
            .collect(Collectors.toList());
        
        Node root = buildTree(nodes);
        
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        
        traverse(root, preorder, postorder);
        
        return new int[][]{
            preorder.stream().mapToInt(Integer::intValue).toArray(),
            postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
    
    private Node buildTree(List<Node> nodes) {
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }
        return root;
    }
    
    private void insertNode(Node parent, Node newNode) {
        if (newNode.x < parent.x) {
            if (parent.left == null) parent.left = newNode;
            else insertNode(parent.left, newNode);
        } else {
            if (parent.right == null) parent.right = newNode;
            else insertNode(parent.right, newNode);
        }
    }
    
    private void traverse(Node node, List<Integer> preorder, List<Integer> postorder) {
        if (node == null) return;
        
        preorder.add(node.idx);
        traverse(node.left, preorder, postorder);
        traverse(node.right, preorder, postorder);
        postorder.add(node.idx);
    }
}