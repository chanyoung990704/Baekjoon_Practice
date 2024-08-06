import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Integer[][] arr = Arrays.stream(book_time)
            .map(i -> Arrays.stream(i)
                .map(j -> convertMinute(j))
                .toArray(Integer[]::new))
            .sorted((a, b) -> a[0] - b[0])
            .toArray(Integer[][]::new);
        
  
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < arr.length; i++) {
            
            if(!pq.isEmpty() && pq.peek() <= arr[i][0]){
                pq.poll();
            }
            
            pq.offer(arr[i][1] + 10);
        }
        
        answer = pq.size();
        return answer;
    }
    
    int convertMinute(String s){
        String[] parts = s.split(":");
        int h = Integer.valueOf(parts[0]);
        int m = Integer.valueOf(parts[1]);
        return h * 60 + m;
    }
}