import java.util.regex.*;

class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for(String str : order){
            Pattern p = Pattern.compile("latte");
            Matcher m = p.matcher(str);
            
            if(m.find()) answer += 5000;
            else answer += 4500;
            
        }
        
        return answer;
    }
}