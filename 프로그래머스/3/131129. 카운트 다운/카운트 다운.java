import java.util.stream.*;
import java.util.*;

class Solution {
    class Node {
        int cnt;
        int s;
        int d;
        int t;
        int b;
        Node(int cnt, int s, int d, int t, int b) {
            this.cnt = cnt;
            this.s = s;
            this.d = d;
            this.t = t;
            this.b = b;
        }
    }
    
    Node[] dp = new Node[100001];
    
    public int[] solution(int target) {
        for(int i = 0; i <= target; i++) {
            dp[i] = new Node(-1, 0, 0, 0, 0);
        }
        
        Node result = solve(target);
        return new int[]{result.cnt, result.s + result.b};
    }
    
    Node solve(int n) {
        if(n < 0) return new Node(-1, 0, 0, 0, 0);
        if(n == 0) return new Node(0, 0, 0, 0, 0);
        
        if(dp[n].cnt != -1) return dp[n];
        
        Node cur = new Node(Integer.MAX_VALUE, 0, 0, 0, 0);
        
        // 불
        if(n >= 50) {
            Node bullResult = solve(n - 50);
            if(bullResult.cnt != -1) {
                cur = updateNode(cur, bullResult, 0, 0, 0, 1);
            }
        }
        
        // 싱글
        for(int i = 1; i <= 20; i++) {
            Node result = solve(n - i);
            if(result.cnt != -1) {
                cur = updateNode(cur, result, 1, 0, 0, 0);
            }
        }
        
        // 더블
        for(int i = 1; i <= 20; i++) {
            Node result = solve(n - i * 2);
            if(result.cnt != -1) {
                cur = updateNode(cur, result, 0, 1, 0, 0);
            }
        }

        // 트리플
        for(int i = 1; i <= 20; i++) {
            Node result = solve(n - i * 3);
            if(result.cnt != -1) {
                cur = updateNode(cur, result, 0, 0, 1, 0);
            }
        }
        
        if(cur.cnt != Integer.MAX_VALUE) {
            dp[n] = cur;
        }
        
        return dp[n];
    }
    
    private Node updateNode(Node cur, Node result, int s, int d, int t, int b) {
        int newCnt = result.cnt + 1;
        if(newCnt < cur.cnt || 
           (newCnt == cur.cnt && result.s + result.b + s + b > cur.s + cur.b)) {
            return new Node(newCnt, 
                          result.s + s, 
                          result.d + d, 
                          result.t + t, 
                          result.b + b);
        }
        return cur;
    }
}