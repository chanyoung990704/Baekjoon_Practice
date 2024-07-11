class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int rest = n % a;
            int get_coke = (n / a) * b;
            answer += get_coke;
            n = get_coke + rest;
        }
        
        return answer;
    }
}