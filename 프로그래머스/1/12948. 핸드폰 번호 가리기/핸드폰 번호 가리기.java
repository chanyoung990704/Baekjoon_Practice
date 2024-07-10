class Solution {
    public String solution(String phone_number) {
        
        StringBuilder sb = new StringBuilder(phone_number);
        
        for(int i = phone_number.length() - 1 - 4 ; i >= 0 ; i--)
            sb.setCharAt(i, '*');
        
        return sb.toString();
    }
}