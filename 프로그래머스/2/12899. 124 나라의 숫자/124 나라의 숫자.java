class Solution {
    public String solution(int n) {
        String answer = "";
  
        while(n != 0){
            
            if(n % 3 == 0){
                answer = "4" + answer;
                n = (n / 3) - 1;
            }else{
                answer = String.valueOf(n % 3) + answer;
                n /= 3;
            }
        }
        
        return answer;
    }
}