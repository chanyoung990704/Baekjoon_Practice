class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        int l = cookie.length;
        for(int p = 0 ; p < l - 1 ; p++) {
            int left = p;
            int right = p + 1;
            int leftSum = cookie[left];
            int rightSum = cookie[right];
            
            while(left >= 0 && right < l) {
                if(leftSum == rightSum) answer = Math.max(answer, leftSum);
                
                if(leftSum <= rightSum && left > 0) leftSum += cookie[--left];
                else if(right < l - 1) rightSum += cookie[++right];
                else break;
            }
            
        }
        
        return answer;
    }
}