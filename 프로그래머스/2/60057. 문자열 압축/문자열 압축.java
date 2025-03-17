import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        
        int ret = Integer.MAX_VALUE;
        if(s.length() == 1){
            return 1;
        }
        // 슬라이싱 개수
        for(int i = 1 ; i <= s.length() / 2 ; i++){
            String prev = "";
            int prevCnt = 0;
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            
            while(idx < s.length()){
                String parsed = s.substring(idx, Math.min(s.length(), idx + i));
                
                // 이전거랑 같은지
                if(parsed.equals(prev)){
                    prevCnt++;
                }
                // 다를 때
                else{
                    // 저장하고 초기화
                    if(prev.length() > 0){
                        if(prevCnt > 1){
                            sb.append(prevCnt);
                        }
                        sb.append(prev);
                    }
                    
                    prev = parsed;
                    prevCnt = 1;
                }
                
                // 다음 인덱스
                idx += i;
            }
            
            // 마지막에 저장 못한 거 
            if(prevCnt > 1){
                sb.append(prevCnt);
            }
            sb.append(prev);
            
            ret = Math.min(ret, sb.length());
        }
        
        return ret;
    }
}