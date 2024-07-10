class Solution {
    
    public int get_gcd(int a, int b){
        if(b == 0)
            return a;
        return get_gcd(b, a % b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int totalNumer = (numer1 * denom2) + (numer2 * denom1);
        int totalDenom = denom1 * denom2;
        
        int gcd = get_gcd(totalNumer, totalDenom);
        
        return new int[]{totalNumer / gcd, totalDenom / gcd};
        
    }
}