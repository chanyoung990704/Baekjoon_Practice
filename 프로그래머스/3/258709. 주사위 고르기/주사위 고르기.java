import java.util.*;
import java.util.stream.*;

class Solution {
    
    class DiceResult{
        List<Integer> idxs;
        int win;
        
        DiceResult(List<Integer> idxs, int win){
            this.idxs = idxs;
            this.win = win;
        }
    }
    
    List<DiceResult> res = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        
        getComb(0, dice, new TreeSet<>());
        
        res.sort(Comparator.comparing((DiceResult dr) -> dr.win).reversed());
        
        return res.get(0).idxs.stream().map(i -> i + 1).mapToInt(Integer::valueOf).toArray();
    }
    
    void getComb(int start, int[][] dice, Set<Integer> results){
        if(results.size() == dice.length / 2){
            System.out.println(results.toString());
            
            List<Integer> aList = new ArrayList<>(results);
            List<Integer> bList = new ArrayList<>();
            for(int i = 0 ; i < dice.length ; i++){
                if(!results.contains(i)){
                    bList.add(i);
                }
            }
            
            List<Integer> aSums = new ArrayList<>();
            List<Integer> bSums = new ArrayList<>();
            dfs(aList, 0, dice, 0, aSums);
            dfs(bList, 0, dice, 0, bSums);
            
            // 이분탐색 진행
            bSums.sort(Comparator.naturalOrder());
            int win = 0;
            for(int i = 0 ; i < aSums.size() ; i++){
                int target = aSums.get(i);
                
                int lo = 0;
                int hi = bSums.size() - 1;
                int ret = -1;
                
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    
                    if(bSums.get(mid) < target){
                        ret = mid;
                        lo = mid + 1;
                    }else{
                        hi = mid - 1;
                    }
                }
                
                win += (ret + 1);
            }
            
            System.out.println(aSums.size() + " " + win);
            
            res.add(new DiceResult(aList, win));
            return;
        }
        
        for(int i = start ; i < dice.length ; i++){
            results.add(i);
            getComb(i + 1, dice, results);
            results.remove(i);
        }
    }
    
    void dfs(List<Integer> list, int idx, int[][] dice, int sum, List<Integer> sums){
        
        if(idx == dice.length / 2){
            sums.add(sum);
            return;
        }
        
        for(int i = 0 ; i < 6 ; i++){
            dfs(list, idx + 1, dice, sum + dice[list.get(idx)][i], sums);
        }
    }
    
}