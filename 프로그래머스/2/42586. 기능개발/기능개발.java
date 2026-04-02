import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> lis = new ArrayList<>();
        
        
        for(int i = 0 ; i < len ; i++){
            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            q.add(days);
        }
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int cnt = 1;
            // 빨리 끝날 수 있는거 전부
            while(!q.isEmpty() && q.peek() <= cur){
                q.poll();
                cnt++;
            }
            lis.add(cnt);
        }
        
        
        int[] answer = new int[lis.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = lis.get(i);
        }
        
        return answer;
    }
}