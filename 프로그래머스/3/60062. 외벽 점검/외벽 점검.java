import java.util.*;
import java.util.stream.*;

class Solution {
    int[] dist;
    int[] weak;
    public int solution(int n, int[] weak, int[] dist) {
        int answer = dist.length + 1;
        this.dist = dist;
        this.weak = weak;
        
        int len = weak.length;
        List<Integer> weakList = new ArrayList<>(Arrays.stream(weak)
                                                       .boxed()
                                                       .collect(Collectors.toList()));
        for(int w : weak) weakList.add(w + n);
        
        boolean[] visited = new boolean[dist.length];
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutation(visited, permutations, new ArrayList<>());
        
        for(int startIdx = 0 ; startIdx < len ; startIdx++) {
            for(List<Integer> permutation : permutations) {
                int count = 1;
                int pos = weakList.get(startIdx) + permutation.get(count - 1);
                for(int i = startIdx ; i < startIdx + len ; i++){
                    if(pos < weakList.get(i)){
                        count++;
                        if(count > dist.length) break;
                        pos = weakList.get(i) + permutation.get(count - 1);
                    }
                }
                answer = Math.min(answer, count);
            }
        }
        
        if(answer > dist.length) return -1;
        
        return answer;
    }
    
    void getPermutation(boolean[] visited, List<List<Integer>> permutations, List<Integer> permutation){
        if(permutation.size() == dist.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0 ; i < dist.length ; i++) {
            if(!visited[i]){
                visited[i] = true;
                permutation.add(dist[i]);
                getPermutation(visited, permutations, permutation);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}