class Solution {
    public int solution(int a, int b) {
        
        String val = String.valueOf(a) + String.valueOf(b);
        int tmpVal = 2 * a * b;
        int intVal = Integer.parseInt(val);
        
        if(tmpVal > intVal) return tmpVal;
        else return intVal;

    }
}