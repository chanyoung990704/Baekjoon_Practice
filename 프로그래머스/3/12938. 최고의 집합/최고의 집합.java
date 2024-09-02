class Solution {
    public int[] solution(int n, int s) {
        // n이 s보다 크면 불가능한 경우
        if (n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        int base = s / n;  // 기본 값
        int remainder = s % n;  // 남은 값
        
        // 배열 채우기
        for (int i = 0; i < n; i++) {
            answer[i] = base;
            // 남은 값이 있으면 뒤에서부터 1씩 더해줌
            if (i >= n - remainder) {
                answer[i]++;
            }
        }
        
        return answer;
    }
}