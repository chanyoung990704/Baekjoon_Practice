import java.util.*;

class Solution {
    public String solution(String p) {        
        return solve(p);
    }
    
    boolean isPossible(String p) {
        Deque<Character> dq = new ArrayDeque<>();
        
        for(char c : p.toCharArray()){
            if(c == '(') dq.offer(c);
            else{
                if(dq.isEmpty()) return false;
                dq.pollLast();
            }
        }
        
        if(dq.isEmpty()) return true;
        return false;
    }
    
    String solve(String p){
        // 입력이 빈 문자열인 경우
        if(p.length() == 0) return "";
        
        String[] parts = partitionP(p);
        
        if(isPossible(parts[0])) return parts[0] + solve(parts[1]);
        else{
            String ret = "(" + solve(parts[1]) + ")";
            String newS = "";
            for(int i = 1 ; i < parts[0].length() - 1 ; i++){
                if(parts[0].charAt(i) == '(') newS += ')';
                else newS += '(';
            }
            return ret + newS;
        }
    }
    
    String[] partitionP(String p){
        int openCnt = 0; // ( 개수
        int closeCnt = 0; // ) 개수
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int idx = 0;
        while(idx < p.length() && (openCnt != closeCnt || idx == 0)){
            char cur = p.charAt(idx++);
            if(cur == '(') openCnt++;
            else closeCnt++;
            u.append(cur);
        }
        while(idx < p.length()) v.append(p.charAt(idx++));
        
        return new String[]{u.toString(), v.toString()};
    }
}