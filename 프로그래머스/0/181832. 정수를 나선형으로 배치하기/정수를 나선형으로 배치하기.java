import java.util.*;
import java.util.stream.*;

class Solution {
    int idx = 1;
    List<List<Integer>> answer = new ArrayList<>();
    public int[][] solution(int n) {
        
        for(int i = 0 ; i < n ; i++)
            answer.add(new ArrayList<>(Collections.nCopies(n, -1)));
        
        dfs(0, 0, 0);
        
        return answer.stream().map(i ->
            i.stream().mapToInt(Integer::valueOf).toArray())
            .toArray(int[][]::new);
    }
    
    void dfs(int y, int x, int dir){
        
        answer.get(y).set(x, idx);
        idx++;
        
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        
        int cnt = 0;
        
        while(true){
            if(cnt == 4) break;
            int i = (dir + cnt) % 4;
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < answer.size() && nx >= 0 && nx < answer.size()){
                if(answer.get(ny).get(nx) == -1){
                    dfs(ny, nx, i);
                }
            }
            cnt++;
        }
        
    }
}