class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;
        
        for (int s : stations) {
            if (s - w > start) {
                int count = (s - w) - start;
                answer += (count + coverage - 1) / coverage;
            }
            start = s + w + 1;
        }
        
        if (start <= n) {
            int count = n - start + 1;
            answer += (count + coverage - 1) / coverage;
        }
        
        return answer;
    }
}