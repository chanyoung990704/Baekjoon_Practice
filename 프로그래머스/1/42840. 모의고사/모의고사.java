import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] answers) {
        
        int[][] patterns = new int[][]{
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        // 시험 문제 순회
        int[] scores = new int[3];
        for(int i = 0 ; i < answers.length ; i++){
            int ans = answers[i];
            for(int j = 0 ; j < 3 ; j++){
                if(ans == patterns[j][i % patterns[j].length]){
                    scores[j]++;
                }
            }
        }
        
        int max = Arrays.stream(scores).max().getAsInt();

        return IntStream.range(0,3).filter(i -> scores[i] == max)
            .map(i -> i+1)
            .sorted()
            .toArray();
    }
}