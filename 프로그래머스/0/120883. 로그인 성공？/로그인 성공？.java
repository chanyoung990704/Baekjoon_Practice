import java.util.Arrays;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        for(String[] cur : db) {
            // 로그인 성공
            if(Arrays.equals(id_pw, cur))
                return "login";
            else if(id_pw[0].equals(cur[0]))
                return "wrong pw";
        }
        
        return "fail";
        
    }
}