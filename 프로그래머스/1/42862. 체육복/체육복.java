import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // 모든 학생이 체육복을 1개씩 가지고 있다고 초기화
        for(int i = 1 ; i <= n ; i++)
            map.put(i, 1);
        
        // 여벌 체육복을 가진 학생 처리
        for(int r : reserve)
            map.put(r, map.get(r) + 1);
        
        // 체육복을 도난당한 학생 처리
        for(int l : lost)
            map.put(l, map.get(l) - 1);
        
        // 체육수업을 들을 수 있는 학생 수 계산
        int answer = 0;
        
        for(int i = 1 ; i <= n ; i++){
            if(map.get(i) >= 1) {
                answer++;
                continue;
            }
            
            if(i > 1 && map.get(i-1) > 1) {
                map.put(i-1, map.get(i-1) - 1);
                answer++;
            } else if(i < n && map.get(i+1) > 1) {
                map.put(i+1, map.get(i+1) - 1);
                answer++;
            }
        }
        
        return answer;
    }
}