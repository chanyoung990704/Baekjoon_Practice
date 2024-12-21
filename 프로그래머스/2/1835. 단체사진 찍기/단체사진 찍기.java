import java.util.*;

class Solution {
    String[] data;
    int answer = 0;
    String[] friends = {"A","C","F","J","M","N","R","T"}; // 상수로 선언
    
    public int solution(int n, String[] data) {
        this.data = data;
        boolean[] visited = new boolean[8];  // 방문 체크 배열
        String[] current = new String[8];    // 현재 순열 저장 배열
        
        permutation(visited, current, 0);
        return answer;
    }
    
    // 최적화된 순열 함수
    void permutation(boolean[] visited, String[] current, int depth) {
        if(depth == 8){
            if(isCorrect(current)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                current[depth] = friends[i];
                permutation(visited, current, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 최적화된 검증 함수
    boolean isCorrect(String[] ret){
        for(String d : data){
            char p1 = d.charAt(0);
            char p2 = d.charAt(2);
            char op = d.charAt(3);
            int distance = d.charAt(4) - '0';
            
            int p1Idx = -1, p2Idx = -1;
            for(int i = 0; i < 8; i++){
                if(ret[i].charAt(0) == p1) p1Idx = i;
                if(ret[i].charAt(0) == p2) p2Idx = i;
            }
            
            int pDistance = Math.abs(p1Idx - p2Idx) - 1;
            
            if(op == '=' && pDistance != distance) return false;
            if(op == '>' && pDistance <= distance) return false;
            if(op == '<' && pDistance >= distance) return false;
        }
        return true;
    }
}
