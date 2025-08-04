import java.util.*;

class Solution {
    int[][] q;
    int res = 0;
    int[] ans;
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        int answer = 0;
        comb(1,n,new BitSet(), new Stack<>());
        return res;
    }
    
    
    void comb(int cur, int n, BitSet visited, Stack<Integer> stack){
        if(stack.size() == 5){
            boolean isAll = true;
            for(int i = 0 ; i < q.length ; i++){
                int correct = 0;
                for(int num : q[i]){
                    if(visited.get(num)){
                        correct++;
                    }
                }
                
                if(correct != ans[i]){
                    isAll = false;
                    break;
                }
            }
            if(isAll){
                res++;
            }
            return;
        }
        
        for(int i = cur ; i <= n ; i++){
            if(!visited.get(i)){
                visited.set(i);
                stack.push(i);
                comb(i+1, n, visited, stack);
                stack.pop();
                visited.clear(i);
            }
        }
    }
}