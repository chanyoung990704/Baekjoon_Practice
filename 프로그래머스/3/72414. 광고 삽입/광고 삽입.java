import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = timeConvertInt(play_time);
        int adv = timeConvertInt(adv_time);
        long[] timeline = new long[play + 1];
        
        for(String log : logs){
            String[] times = log.split("-");
            int start = timeConvertInt(times[0]);
            int end = timeConvertInt(times[1]);
            timeline[start] += 1;
            timeline[end] -= 1;
        }
        
        for(int i = 1 ; i <= play ; i++) timeline[i] += timeline[i - 1];
        for(int i = 1 ; i <= play ; i++) timeline[i] += timeline[i - 1];
        
        long maxView = timeline[adv - 1];
        int maxTime = 0;
        
        for(int start = 1 ; start + adv - 1 <= play ; start++){
            long totalView = timeline[start + adv - 1] - timeline[start - 1];
            if(totalView > maxView){
                maxView = totalView;
                maxTime = start;
            }
        }
        
        return timeConvertString(maxTime);
    }
    
    
    int timeConvertInt(String time){
        int[] t = Arrays.stream(time.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        return t[0] * 3600 + t[1] * 60 + t[2];
    }
    
    String timeConvertString(int time){
        StringBuilder sb = new StringBuilder();
        if(time / 3600 >= 10) sb.append(time / 3600 + ":");
        else sb.append("0" + time / 3600 + ":");
        
        time %= 3600;
        if(time / 60 >= 10) sb.append(time / 60 + ":");
        else sb.append("0" + time / 60 + ":");    
    
        time %= 60;
        if(time >= 10) sb.append(time);
        else sb.append("0" + time);
        
        return sb.toString();
    }
}