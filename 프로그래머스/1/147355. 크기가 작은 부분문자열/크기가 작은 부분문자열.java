class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        
        for (int i = 0; i <= t.length() - pLength; i++) {
            String subStr = t.substring(i, i + pLength);
            if (subStr.compareTo(p) <= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
