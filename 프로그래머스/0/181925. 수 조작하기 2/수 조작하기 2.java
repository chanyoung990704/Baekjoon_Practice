import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i < numLog.length ; i++)
            list.add(numLog[i] - numLog[i - 1]);
        
        StringBuilder sb = new StringBuilder();
        for(int n : list){
            switch(n){
                case 1:
                    sb.append("w");
                    break;
                case -1:
                    sb.append("s");
                    break;
                case 10:
                    sb.append("d");
                    break;
                case -10:
                    sb.append("a");
                    break;
                default:
                    continue;
            }
        }
        return sb.toString();
    }
}