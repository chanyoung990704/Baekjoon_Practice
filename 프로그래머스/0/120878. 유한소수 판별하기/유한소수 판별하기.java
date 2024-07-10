class Solution {
    
    public int get_gcd(int a, int b){
        if(b == 0)
            return a;      
        return get_gcd(b, a % b);
    }
    
    public int solution(int a, int b) {
        int gcd = get_gcd(a, b);
        
        a /= gcd;
        b /= gcd;
        
        // 5로 나누기
        while(b % 5 == 0){
            b /= 5;
        }
        
        // 2로 나누기
        while(b % 2 ==0){
            b /= 2;
        }
        
        return b == 1 ? 1 : 2;
    }
}