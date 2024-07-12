import java.util.*;
import java.util.stream.*;

class Solution {
    
    class StageInfo{
        double failure;
        int idx;
        
        StageInfo(double failure, int idx){
            this.failure = failure;
            this.idx = idx;
        }
        
        public double getFailure(){
            return this.failure;
        }
    
        public int getIdx(){
            return this.idx;
        }
        
    }
    
    public int[] solution(int N, int[] stages) {
        return IntStream.range(1, N + 1)
            .mapToObj(i -> {
                long totalPlayers = Arrays.stream(stages)
                    .filter(j -> j >= i).count();
                long failedPlayers = Arrays.stream(stages)
                    .filter(j -> j == i).count();
                double failureRate = totalPlayers > 0 ?
                    (double) failedPlayers / totalPlayers : 0;
                return new StageInfo(failureRate, i);
            })
            .sorted(Comparator.comparing(StageInfo::getFailure).reversed()
                   .thenComparing(Comparator.comparing(StageInfo::getIdx)))
            .mapToInt(StageInfo::getIdx)
            .toArray();
    }
}