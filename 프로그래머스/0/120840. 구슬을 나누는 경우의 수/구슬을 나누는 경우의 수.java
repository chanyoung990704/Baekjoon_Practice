class Solution {
    public long solution(int balls, int share) {
        return combination(balls, share);
    }
    
    private long combination(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }
        
        long numerator = 1;
        long denominator = 1;
        
        for (int i = 0; i < r; i++) {
            numerator *= (n - i);
            denominator *= (i + 1);
            
            // 분자와 분모의 최대공약수로 나누어 오버플로우 방지
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator / denominator;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
