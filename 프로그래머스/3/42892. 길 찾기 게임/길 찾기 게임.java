import java.util.*;
import java.util.stream.*;

class Solution {
    class Node{
        int x;
        int y;
        int idx;
        
        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        int getX(){return x;}
        int getY(){return y;}
    }
    
    class Tree{
        Node root;
        Tree left;
        Tree right;
        
        Tree(Node root){
            this.root = root;
            left = null;
            right = null;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        
        List<Node> list = new ArrayList<>();
        for(int i = 1 ; i <= nodeinfo.length ; i++){
            list.add(new Node(nodeinfo[i - 1][0], nodeinfo[i - 1][1], i));
        }
        
        // node 2번쨰 원소 내림차순, 1번째 원소 오름차순
        list.sort(Comparator.comparing(Node::getY).reversed()
                            .thenComparing(Comparator.comparing(Node::getX)));
        
        // 트리 생성
        Tree tree = new Tree(list.get(0));
        
        for(int i = 1; i < list.size() ; i++){
            int cur =  list.get(i).getX();
            Tree tmp = tree;
            while(true){
                if(tmp.root.getX() < cur){
                    if(tmp.right == null) break;
                    tmp = tmp.right;
                }else{
                    if(tmp.left == null) break;
                    tmp = tmp.left;
                }
            }
            if(tmp.root.getX() < cur) tmp.right = new Tree(list.get(i));
            else tmp.left = new Tree(list.get(i));
        }
        
        // 트리 순회
        List<Integer> result1 = new ArrayList<>();
        printTree(tree, result1);
        
        List<Integer> result2 = new ArrayList<>();
        printTree2(tree, result2);
        
        return new int[][]{result1.stream()
                                  .mapToInt(Integer::valueOf)
                                  .toArray(),
                          result2.stream()
                                 .mapToInt(Integer::valueOf)
                                 .toArray()};
    }
    
    void printTree(Tree tree, List<Integer> result) {
        result.add(tree.root.idx);
        if(tree.left != null) printTree(tree.left, result);
        if(tree.right != null) printTree(tree.right, result);
    }
    
    void printTree2(Tree tree, List<Integer> result){
        if(tree == null) return;
        
        printTree2(tree.left,result);
        printTree2(tree.right, result);
        result.add(tree.root.idx);
    }
    
}