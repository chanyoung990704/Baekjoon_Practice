
class Solution {
    public String solution(String a, String b) {
        
        StringBuilder sb_a = new StringBuilder(a).reverse();
        StringBuilder sb_b = new StringBuilder(b).reverse();
        StringBuilder sb = new StringBuilder();
        
        int min = Math.min(a.length(), b.length());
        int idx = 0;
        boolean ceil = false;
        while(idx < min){
            int sum = 0;
            if(ceil) sum = 1;
            sum += sb_a.charAt(idx) - '0';
            sum += sb_b.charAt(idx) - '0';
            
            if(sum >= 10){
                sb.append(String.valueOf(sum % 10));
                ceil = true;
            }else{
                sb.append(String.valueOf(sum));
                ceil = false;
            }
            
            idx++;
        }
        
        while(idx < a.length()){
            int sum = 0;
            if(ceil) sum = 1;
            sum += sb_a.charAt(idx) - '0';
            if(sum >= 10){
                sb.append(String.valueOf(sum % 10));
                ceil = true;
            }else{
                sb.append(String.valueOf(sum));
                ceil = false;
            }
            
            idx++;            
        }
        
        while(idx < b.length()) {
            int sum = 0;
            if(ceil) sum = 1;
            sum += sb_b.charAt(idx) - '0';
            if(sum >= 10){
                sb.append(String.valueOf(sum % 10));
                ceil = true;
            }else{
                sb.append(String.valueOf(sum));
                ceil = false;
            }
            
            idx++;               
        }
        
        if(ceil) sb.append("1");
        
        return sb.reverse().toString();
        
    }
}