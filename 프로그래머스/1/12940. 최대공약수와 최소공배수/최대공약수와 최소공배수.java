class Solution {
    
    public int get_gcd(int a, int b){
        if(b == 0)
            return a;
        return get_gcd(b, a % b);
    }
    
    public int get_lcm(int a, int b){
        return a * b / get_gcd(a, b);
    }
    
    public int[] solution(int n, int m) {
        return new int[]{get_gcd(n, m), get_lcm(n, m)};
    }
}