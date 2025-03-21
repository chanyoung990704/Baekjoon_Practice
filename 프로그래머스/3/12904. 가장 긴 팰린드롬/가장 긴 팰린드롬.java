class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            // 좌우 투포인터 진행
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                max = Math.max(max, right - left + 1);
                right++;
                left--;
            }
            
            if(i < s.length() - 1){
                left = i;
                right = i + 1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    max = Math.max(max, right - left + 1);
                    right++;
                    left--;
                }                
            }
        }
        
        return max;
    }
}