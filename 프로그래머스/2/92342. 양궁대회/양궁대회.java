import java.util.*;

class Solution {
    int n;
    int[] info;
    int max = Integer.MIN_VALUE;
    List<int[]> optimalSolutions = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        
        int[] data = new int[info.length];
        solve(data, 0, 0);
        
        // 라이언이 이길 수 없는 경우
        if (max <= 0) {
            return new int[]{-1};
        }
        
        // 여러 최적 해결책 중 가장 적절한 것을 선택
        return chooseBestSolution(optimalSolutions);
    }
    
    void solve(int[] data, int idx, int cnt){
        if(cnt == n){
            int appeach = 0;
            int lion = 0;
            for(int i = 0; i < info.length; i++){
                if(info[i] > 0 || data[i] > 0){
                    if(data[i] > info[i]) lion += (10 - i);
                    else appeach += (10 - i);
                }
            }
            if(lion > appeach){
                int diff = lion - appeach;
                if(diff > max){
                    max = diff;
                    optimalSolutions.clear();
                    optimalSolutions.add(Arrays.copyOf(data, data.length));
                } else if(diff == max){
                    optimalSolutions.add(Arrays.copyOf(data, data.length));
                }
            }
            return;
        }

        for(int i = idx; i < data.length; i++){
            data[i]++;
            solve(data, i, cnt + 1);
            data[i]--;
        }
    }
    
    int[] chooseBestSolution(List<int[]> solutions) {
        int[] best = solutions.get(0);
        for (int[] solution : solutions) {
            for (int i = 10; i >= 0; i--) {
                if (solution[i] > best[i]) {
                    best = solution;
                    break;
                } else if (solution[i] < best[i]) {
                    break;
                }
            }
        }
        return best;
    }
}