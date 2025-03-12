import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        
        // 원형 이어 붙이기
        List<Integer> newWeak = Arrays.stream(weak).boxed().map(i -> i + n)
            .collect(Collectors.toList());
        
        List<Integer> weakList = Arrays.stream(weak).boxed().collect(Collectors.toList());
        weakList.addAll(newWeak);
        
        // dist 순열
        List<int[]> distPermutation = new ArrayList<>();
        getPermutation(distPermutation, dist, new boolean[dist.length], new ArrayDeque<>());
        
        int ret = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < weak.length ; i++){
            int start = weakList.get(i);
            
            // 시작점부터 순열
            for(int[] per : distPermutation){
                int idx = 0;
                int cnt = 0;
                int need = start;
                // 점검
                for(int j = i ; j < i + weak.length ; j++){
                    
                    // 점검 완료된 것들
                    if(need > weakList.get(j)){
                        cnt++;
                        continue;
                    }
                    
                    // 친구 투입
                    if(idx < per.length){
                        need = weakList.get(j) + per[idx] + 1;
                        idx++;
                        cnt++;
                    }
                }
                
                if(cnt == weak.length && idx <= per.length){
                    ret = Math.min(ret, idx);
                }
            }
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
    
    void getPermutation(List<int[]> permutation, int[] dist, boolean[] visited, Deque<Integer> res){
        if(dist.length == res.size()){
            permutation.add(res.stream().mapToInt(Integer::valueOf).toArray());
            return;
        }
        
        for(int i = 0 ; i < dist.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                res.offerLast(dist[i]);
                getPermutation(permutation, dist, visited, res);
                res.pollLast();
                visited[i] = false;
            }
        }
    }
}