import java.util.*;

class Solution {
    
    class Node{
        int c;
        int s;
        int d;
        int t;
        int b;
        Node(int c, int s, int d, int t, int b){
            this.c = c;
            this.s = s;
            this.d = d;
            this.t = t;
            this.b = b;
        }
    }
    
    Node[] dp = new Node[100000 + 1];
    
    public int[] solution(int target) {
        for(int i = 0 ; i < dp.length ; i++) dp[i] = new Node(-1,0,0,0,0);
        workDp(target);
        return new int[]{dp[target].c, dp[target].s + dp[target].b};
    }
    
    Node workDp(int target){
        
        if(target < 0) return new Node(-1,0,0,0,0);
        if(target == 0) return new Node(0,0,0,0,0);
        
        if(dp[target].c != -1) return dp[target];
        
        Node ret = new Node(Integer.MAX_VALUE, 0,0,0,0);
        
        // 불
        Node n = workDp(target - 50);
        if(n.c != -1){
            ret = updateNode(ret, n, 0, 0, 0, 1);
        }
        
        // 싱글
        for(int i = 1 ; i <= 20 ;i++){
            n = workDp(target - i);
            if(n.c != -1) ret = updateNode(ret, n, 1, 0, 0, 0);
        }
        
        // 더블
        for(int i = 1; i <= 20 ; i++){
            n = workDp(target - i * 2);
            if(n.c != -1) ret = updateNode(ret, n, 0, 1, 0, 0);
            
        }
        
        // 트리플
        for(int i = 1; i <= 20 ; i++){
            n = workDp(target - i * 3);
            if(n.c != -1) ret = updateNode(ret, n, 0, 0, 1, 0);
        }
        
        if(ret.c != Integer.MAX_VALUE) dp[target] = ret;
        return dp[target];
        
    }
    
    Node updateNode(Node cur, Node result, int s, int d, int t, int b){
        int cnt = result.c + 1;
        if((cnt < cur.c) || (cnt == cur.c && cur.b + cur.s < result.b + b + result.s + s)){
            return new Node(cnt, result.s + s, result.d + d, result.t + t, result.b + b);
        }
        return cur;
    }
}