class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int cur = 0;
        
        for(int sec : section){
            if(cur < sec){
                cur = sec + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}