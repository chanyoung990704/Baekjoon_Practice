import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String dartResult) {
        
        List<Integer> list = new ArrayList<>(); // 숫자 저장
        
        String prev = "";
        for(char c : dartResult.toCharArray()) {
            
            // 싱글 더블 트리플
            if(c == 'S' || c == 'D' || c == 'T'){
                int val;
                if(c == 'S')
                    val = 1;
                else if(c == 'D')
                    val = 2;
                else
                    val = 3;
                list.add((int)Math.pow(Integer.valueOf(prev), val));
                prev = "";
                continue;
            }
            
            // *이거나 #일 경우
            if(c == '*' || c == '#'){
                int len = list.size();
                if(c == '#'){
                    list.set(len - 1, list.get(len - 1) * -1);
                }
                else if(c == '*'){
                    if(len == 1)
                        list.set(0, list.get(0) * 2);
                    else
                        for(int i = 1 ; i <= 2 ; i++)
                            list.set(len - i, list.get(len - i) * 2);
                }
                
                continue;
            }
            
            // 숫자일 경우
            prev += c;
        }
        
        return (int)list.stream().mapToInt(Integer::valueOf).sum();
        
    }
}