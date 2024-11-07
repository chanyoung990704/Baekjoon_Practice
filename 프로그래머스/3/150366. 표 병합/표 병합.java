import java.util.*;
import java.util.stream.*;

class Solution {
    
    List<String> res = new ArrayList<>();
    Map<Integer, String> words = new HashMap<>();
    int[] parent = new int[2500];
    
    public String[] solution(String[] commands) {
        for(int i = 0 ; i < 2500 ; i++) parent[i] = i;
        
        for(String command : commands) {
            String[] works = command.split(" ");
            switch(works[0]){
                case "UPDATE":
                    if(works.length == 3) updateValAll(works);
                    else if(works.length == 4) update(works);
                    break;
                case "MERGE":
                    merge(works);
                    break;
                case "UNMERGE":
                    unMerge(works);
                    break;
                case "PRINT":
                    print(works);
                    break;
                default:
                    break;
            }
            
        }

        return res.stream().toArray(String[]::new);
    }
    
    void merge(String[] works){
        int idx1 = convertIdx(works[1], works[2]);
        int root1 = findParent(idx1);
        String val1 = words.getOrDefault(root1, null);
        
        int idx2 = convertIdx(works[3], works[4]);
        int root2 = findParent(idx2);
        String val2 = words.getOrDefault(root2, null);
        
        // 같은 셀 무시
        if(root1 == root2) return;
        
        if(val1 != null && val2 == null){
            unionParent(root1, root2);
            words.remove(root1);
            words.put(findParent(root1), val1);
        }else if(val1 == null && val2 != null){
            unionParent(root1, root2);
            words.remove(root2);
            words.put(findParent(root2), val2);
        }else if(val1 != null && val2 != null){
            unionParent(root1, root2);
            words.remove(root1);
            words.remove(root2);
            words.put(findParent(root1), val1);
        }else{
            unionParent(root1, root2);
        }
    }
    
    void unMerge(String[] works){
        int rootIdx = findParent(convertIdx(works[1], works[2]));
        String val = words.getOrDefault(rootIdx, null);
        words.remove(rootIdx);
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < 2500 ; i++)
            if(findParent(i) == rootIdx) set.add(i);
        
        for(int idx : set) parent[idx] = idx;
        if(val != null){
            words.put(convertIdx(works[1], works[2]), val);
        }
    }
    
    void update(String[] works){
        int idx = findParent(convertIdx(works[1], works[2]));
        words.put(idx, works[3]);
    }

    void updateValAll(String[] works){
        Map<Integer, String> tmp = new HashMap<>(words);
        for(Map.Entry<Integer, String> e : tmp.entrySet()){
            if(e.getValue().equals(works[1])) words.put(e.getKey(), works[2]);
        }
    }
    
    int convertIdx(String sy, String sx){
        int y = Integer.parseInt(sy);
        int x = Integer.parseInt(sx);
        return (y - 1) * 50 + (x - 1);
    }
    
    void print(String[] works){
        int idx = findParent(convertIdx(works[1], works[2]));
        String val = words.getOrDefault(idx, null);
        if(val == null) res.add("EMPTY");
        else res.add(val);
    }
    
    void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        if(rootA != rootB){
            if(rootA > rootB) parent[rootA] = rootB;
            else parent[rootB] = rootA;
        }
    }
    
    int findParent(int n){
        if(parent[n] != n) parent[n] = findParent(parent[n]);
        return parent[n];
    }
}