class Solution {
    public String solution(int[] food) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i < food.length ; i++)
            for(int j = 0 ; j < food[i] / 2 ; j++)
                sb.append(String.valueOf(i));
                
        result.append(sb.toString());
        result.append("0");
        sb.reverse();
        result.append(sb.toString());
        
        
        return result.toString();
    }
}