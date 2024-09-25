import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] target = scores[0];
        int sum = target[0] + target[1];
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        
        int max = -1;
        for(int[] score : scores){
            if(target[0] < score[0] && target[1] < score[1]) return -1;
            if(score[1] >= max){
                max = score[1];
                if(sum < score[0] + score[1]) answer++;
            }
        }
        
        return answer;
    }
}