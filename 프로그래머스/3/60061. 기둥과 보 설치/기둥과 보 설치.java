import java.util.*;
import java.util.stream.*;

class Solution {
    Set<List<Integer>> set = new HashSet<>();
    
    public int[][] solution(int n, int[][] build_frame) {        
        for(int[] b : build_frame){
            int x = b[0], y = b[1], stuff = b[2], op = b[3];
            List<Integer> structure = List.of(x, y, stuff);
            
            if(op == 1){
                set.add(structure);
                if(!isPossible()) set.remove(structure);
            } else if(op == 0){
                set.remove(structure);
                if(!isPossible()) set.add(structure);
            }
        }
        
        return set.stream()
            .sorted((a, b) -> {
                if(!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
                else if(!a.get(1).equals(b.get(1))) return a.get(1) - b.get(1);
                else return a.get(2) - b.get(2);
            })
            .map(l -> new int[]{l.get(0), l.get(1), l.get(2)})
            .toArray(int[][]::new);
    }
    
    boolean isPossible(){
        for(List<Integer> s : set) {
            int x = s.get(0), y = s.get(1), stuff = s.get(2);
            if(stuff == 0){ // 기둥
                if(y == 0 || set.contains(Arrays.asList(x-1, y, 1)) || 
                   set.contains(Arrays.asList(x, y, 1)) || 
                   set.contains(Arrays.asList(x, y-1, 0))) continue;
                return false;
            } else if(stuff == 1){ // 보
                if(set.contains(Arrays.asList(x, y-1, 0)) || 
                   set.contains(Arrays.asList(x+1, y-1, 0)) ||
                   (set.contains(Arrays.asList(x-1, y, 1)) && set.contains(Arrays.asList(x+1, y, 1)))) continue;
                return false;
            }
        }
        return true;
    }
}