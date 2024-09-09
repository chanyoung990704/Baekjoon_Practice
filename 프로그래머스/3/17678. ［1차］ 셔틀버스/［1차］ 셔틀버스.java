import java.util.*;
import java.util.stream.*;

class Solution {
    int n, t, m;
    String[] timetable;
    public String solution(int n, int t, int m, String[] timetable) {
        this.n = n;
        this.t = t;
        this.m = m;
        this.timetable = timetable;
        String answer = "";

        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(String time : timetable) minHeap.offer(convertTime(time));
        
        int curTime = convertTime("9:00");
        while(true) {
            // 버스가 한번일 때
            if(n == 1){
                // 자리가 충분히 남았을 때
                if(minHeap.size() < m) answer = convertTimeString(curTime);
                else {
                    int lastTime = 0;
                    for (int i = 0; i < m; i++) {
                        lastTime = minHeap.poll();
                    }
                    answer = convertTimeString(Math.min(curTime, lastTime - 1));
                }
                break;
            }
            
            int cnt = 0;
            // 반복해서 빼주기
            while(!minHeap.isEmpty() && n > 1 && minHeap.peek() <= curTime && cnt < m){
                minHeap.poll();
                cnt++;
            }
            
            curTime += t;
            n--;
            
        }
        
        return answer;
    }
    
    int convertTime(String s) {
        List<Integer> list = Arrays.stream(s.split(":"))
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toList());
        return list.get(0) * 60 + list.get(1);
    }
    
    String convertTimeString(int t) {
        String res = "";
        int h = t / 60;
        if(h < 10) res += "0" + h + ":";
        else res += h + ":";
        int m = t % 60;
        if(m < 10) res += "0" + m;
        else res += "" + m;
        
        return res;
    }
    
}