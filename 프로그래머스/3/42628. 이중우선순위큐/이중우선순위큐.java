import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] operations) {
        // 트리맵
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // 삽입
        for(String op : operations){
            // 숫자 파싱
            int num = Integer.valueOf(op.substring(op.lastIndexOf(" ") + 1));
            // 삽입
            if(op.startsWith("I")){
                map.put(num, 1);
            }
            // 삭제
            else if(op.startsWith("D")){
                if(map.isEmpty()){
                    continue;
                }
                
                if(num == 1){
                    // 최댓값 삭제
                    map.remove(map.lastKey());
                }else if(num == -1){
                    // 최소값 삭제
                    map.remove(map.firstKey());
                }
            }
        }
        int[] answer = new int[2];
        if(map.isEmpty()){
            return new int[]{0,0};
        }
        answer[0] = map.lastKey();
        answer[1] = map.firstKey();
        return answer;
    }
}