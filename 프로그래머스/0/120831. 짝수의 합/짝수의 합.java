class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(var i = 1 ; i <= n ; i++)
            if(i % 2 == 0)
                answer += i;
        
        return answer;
    }
}