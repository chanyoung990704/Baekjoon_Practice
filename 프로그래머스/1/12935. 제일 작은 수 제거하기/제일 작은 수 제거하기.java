import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // 길이가 1일 때
        if(arr.length == 1)
            return new int[]{-1};
        
        // 최솟값 찾기
        int minVal = Arrays.stream(arr).min().getAsInt();
        
        return Arrays.stream(arr)
            .filter(i -> i != minVal)
            .toArray();
        
    }
}