import java.util.*;
import java.util.stream.*;
import java.time.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        // 줄 서는게 우선 그리고 탑승
        
        Arrays.sort(timetable);
        
        int idx = 0; // 타임 테이블
        LocalTime bus = LocalTime.of(9, 0);
        LocalTime last = LocalTime.of(0,0);
        
        for(int i = 0 ; i < n; i++){
            int cap = 0;
            
            while(cap < m && idx < timetable.length){
                
                String[] parse = timetable[idx].split(":");
                LocalTime cur = LocalTime.of(Integer.valueOf(parse[0]), Integer.valueOf(parse[1]));
                // 못태우면 종료
                if(cur.isAfter(bus)){
                    break;
                }
                
                last = cur;
                idx++;
                cap++;
                
            }
            
            // 마지막 시간인 경우
            if(i == n - 1){
                // 인원 충분한 경우
                if(cap < m){
                    return bus.toString();
                }
                else{
                    // 마지막 인덱스보다 1분 더 빠르게
                    last = last.minusMinutes(1);
                    return last.toString();
                }
            }
            
            // 다음 버스 도착 시간
            bus = bus.plusMinutes(t);
        }
        
        
        String answer = "";
        return answer;
    }
}