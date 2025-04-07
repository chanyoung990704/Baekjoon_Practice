import java.util.*;

class Solution {
    
    class Node {
        Node next;
        Node prev;
        boolean removed;
    }
    
    public String solution(int n, int k, String[] cmd) {
        
        Node start = new Node();
        
        Node[] nodes = new Node[n];
        nodes[0] = start;
        
        // 노드 연결
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }
        
        Node cur = nodes[k];
        Deque<Node> dq = new ArrayDeque<>();
        
        for (String c : cmd) {
            String[] parsed = c.split(" ");
            String op = parsed[0];
            
            if (op.equals("U") || op.equals("D")) {
                int m = Integer.valueOf(parsed[1]);
                for (int i = 0; i < m; i++) {
                    if (op.equals("U")) {
                        cur = cur.prev;
                    } else {
                        cur = cur.next;
                    }
                }
            }
            
            // 삭제
            if (op.equals("C")) {
                cur.removed = true;
                dq.offerLast(cur);
                // 마지막 행인 경우
                if (cur.next == null) {
                    cur.prev.next = null;
                    cur = cur.prev;
                } else if (cur.prev == null) { // 첫 번째 행인 경우
                    cur.next.prev = null;
                    cur = cur.next;
                } else { // 중간 행인 경우
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    cur = cur.next;
                }
            }
            
            // 복구
            if (op.equals("Z")) {
                Node restoredNode = dq.pollLast();
                restoredNode.removed = false;
                
                if (restoredNode.prev != null) {
                    restoredNode.prev.next = restoredNode;
                }
                if (restoredNode.next != null) {
                    restoredNode.next.prev = restoredNode;
                }
            }
        }
        
        // 결과 생성
        StringBuilder answerBuilder = new StringBuilder();
        for (Node node : nodes) {
            if (node.removed) {
                answerBuilder.append("X");
            } else {
                answerBuilder.append("O");
            }
        }
        
        return answerBuilder.toString();
    }
}
