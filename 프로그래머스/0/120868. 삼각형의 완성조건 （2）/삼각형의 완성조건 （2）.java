class Solution {
    public int solution(int[] sides) {
        int longer = Math.max(sides[0], sides[1]);
        int shorter = Math.min(sides[0], sides[1]);
        
        // 가장 긴 변이 longer인 경우
        int count1 = longer - (longer - shorter);
        
        // 새로운 변이 가장 긴 경우
        int count2 = (longer + shorter) - longer - 1;
        
        return count1 + count2;
    }
}
