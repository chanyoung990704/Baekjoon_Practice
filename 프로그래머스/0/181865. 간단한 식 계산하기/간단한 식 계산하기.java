class Solution {
    public int solution(String binomial) {
        
        String[] splited = binomial.split(" ");
        
        int a = Integer.parseInt(splited[0]);
        int b = Integer.parseInt(splited[2]);
        
        switch(splited[1]){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return -1;
        }
    }
}