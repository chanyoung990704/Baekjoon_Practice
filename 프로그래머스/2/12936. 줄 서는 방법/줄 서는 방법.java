import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // 팩토리얼 계산
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // 숫자 리스트 초기화
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // k번째 순열 찾기
        k--; // 0-based index로 변환
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (int)(k / factorial[n - 1 - i]);
            result[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial[n - 1 - i];
        }
        
        return result;
    }
}