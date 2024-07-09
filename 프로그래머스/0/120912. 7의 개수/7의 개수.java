import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        
        String[] arr = Arrays.stream(array).mapToObj(String::valueOf)
                        .toArray(String[]::new);
        
        int answer = 0;
        
        for(var a : arr)
            for(var c : a.toCharArray())
                if(c - '0' == 7)
                    answer++;
                    
        
        return answer;
    }
}