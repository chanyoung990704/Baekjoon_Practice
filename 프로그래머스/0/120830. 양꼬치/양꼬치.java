class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 양꼬치
        answer += (12000 * n);
        
        //음료수
        answer += (2000 * k);
        
        // 할인
        answer -= (2000 * (n / 10));
        
        
        return answer;
    }
}