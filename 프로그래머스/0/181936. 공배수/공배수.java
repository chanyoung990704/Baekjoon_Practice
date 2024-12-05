class Solution {
    public int solution(int number, int n, int m) {
        
        if(gcd(number, n) == n && gcd(number, m) == m) return 1;
        else return 0;
        
    }
    
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}