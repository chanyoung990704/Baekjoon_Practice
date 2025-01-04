import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length(); // 초기값은 원본 문자열의 길이
        int len = s.length();
        
        for (int i = 1; i <= len / 2; i++) { // 압축 단위
            String prev = ""; // 이전 문자열
            StringBuilder result = new StringBuilder(); // 결과 저장 (StringBuilder 사용)
            int cnt = 1; // 연속 횟수
            
            for (int j = 0; j < len; j += i) {
                String sub = s.substring(j, Math.min(j + i, len)); // 현재 부분 문자열
                
                if (!sub.equals(prev)) { // 연속되지 않는 경우
                    if (cnt > 1) {
                        result.append(cnt).append(prev); // 카운트와 함께 추가
                    } else if (!prev.isEmpty()) {
                        result.append(prev); // 이전 문자열 추가
                    }
                    prev = sub; // 현재 문자열 갱신
                    cnt = 1; // 카운트 초기화
                } else { 
                    cnt++; // 연속된 경우 카운트 증가
                }
            }
            
            // 마지막 남은 부분 처리
            if (cnt > 1) {
                result.append(cnt).append(prev);
            } else {
                result.append(prev);
            }
            
            answer = Math.min(answer, result.length()); // 최소값 갱신
        }
        
        return answer;
    }
}
