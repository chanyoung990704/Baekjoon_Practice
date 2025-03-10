import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        return getCnt(dungeons, new boolean[dungeons.length], k, new ArrayList<>());
    }
    
    int getCnt(int[][] dungeons, boolean[] visited, int k, List<int[]> res){
        if(res.size() == dungeons.length){
            int cnt = 0;
            for(int i = 0 ; i < res.size() ; i++){
                int[] cur = res.get(i);
                // 탐험이 불가능하면
                if(cur[0]>k){
                    break;
                }
                k -= cur[1];
                cnt++;
            }
            return cnt;
        }
        
        int ret = 0;
        
        // 순열
        for(int i = 0 ; i < dungeons.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                res.add(new int[]{dungeons[i][0], dungeons[i][1]});
                ret = Math.max(ret, getCnt(dungeons, visited, k, res));
                res.remove(res.size() - 1);
                visited[i] = false;
            }
        }
        
        return ret;
    }
}