class Solution {
    public String solution(int n, int t, int m, int p) {
        // n진법 만들기
        String answer = "0";
        
        int num = 1;
        while(answer.length() < m * t){
            answer += convertNum(num, n);
            num++;
        }
        
        // 정답 만들기
        String ret = "";
        int cnt = 0;
        while(cnt < t){
            ret += "" + answer.charAt(p - 1 + (m * cnt));
            cnt++;
        }
        
        return ret;
    }
    
    
    String convertNum(int num, int n) {
        String ret = "";
        while(num != 0){
            String val = num % n >= 10 ? convertN(num % n) :
            String.valueOf(num % n);
            ret = val + ret;
            num /= n;
        }
        return ret;
    }
    
    String convertN(int n){
        switch (n){
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return "ERR";
        }
    }
    
    
}