import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < priorities.length ; i++){
            q.offer(i);
        }
        
        int[] orders = new int[priorities.length];
        
        int order = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            int size = q.size();
            boolean prior = true;
            
            for(int i = 0 ; i < size ; i++){
                int next = q.poll();
                if(priorities[cur] < priorities[next]){
                    prior = false;
                }
                q.offer(next);
            }
            
            if(prior){
                orders[cur] = order++;
                continue;
            }
            
            q.offer(cur);
        }
        
        return orders[location];
    }
}