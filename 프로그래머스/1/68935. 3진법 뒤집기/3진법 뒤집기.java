class Solution {
    public int solution(int n) {
        // 10진법 -> 3진법으로 변환 및 뒤집기
        StringBuilder ternary = new StringBuilder();
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }
        // 3진법 -> 10진법으로 변환
        return Integer.valueOf(ternary.toString(), 3);
    }
}
