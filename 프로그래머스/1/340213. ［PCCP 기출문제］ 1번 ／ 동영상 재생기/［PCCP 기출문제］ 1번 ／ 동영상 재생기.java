import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int cur = getSecond(pos);
        int len = getSecond(video_len);
        int start = getSecond(op_start);
        int end = getSecond(op_end);
        
        if(start <= cur && cur <= end) cur = end;
  
        for(String command : commands){                 
            switch(command) {
                case "prev":
                    if(cur < 10) cur = 0;
                    else cur -= 10;
                    break;
                case "next":
                    if(len - cur < 10) cur = len;
                    else cur += 10;
                    break;
                    
                default:               
            }
            
            if(start <= cur && cur <= end) cur = end;

        }
        
        
        return getMinute(cur);
    }
    
    int getSecond(String t){
        List<Integer> list = Arrays.stream(t.split(":")).map(Integer::valueOf)
            .collect(Collectors.toList());
        return list.get(0) * 60 + list.get(1);
    }
    
    String getMinute(int t){
        StringBuilder sb = new StringBuilder();
        int m = t / 60;
        if(m < 10) sb.append("0");
        sb.append(String.valueOf(m));
        
        sb.append(":");
        
        int s = t % 60;
        if(s < 10) sb.append("0");
        sb.append(String.valueOf(s));
        
        return sb.toString();
    }
}