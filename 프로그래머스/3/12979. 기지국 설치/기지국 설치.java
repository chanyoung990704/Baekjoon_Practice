import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 구간 만들기
        List<Integer> d = new ArrayList<>();
        int start = 1;
        for(int station : stations){
            // 전파 최소 지점
            int min = station - w;
            // 시작 지점이 최소 지점보다 뒤에 있어야 구간 형성
            if(start < min){
                // 구간의 개수 저장
                d.add(min - 1 - start + 1);
            }
            start = station + w + 1;
        }
        
        // 마지막 구간이 있는 경우
        if(start <= n){
            d.add(n - start + 1);
        }
        
        // 개당 커버리지
        int coverage = 2 * w + 1;
        int cnt = 0;
        
        for(int num : d){
            cnt += (num + coverage - 1) / coverage;
        }

        return cnt;
    }
}