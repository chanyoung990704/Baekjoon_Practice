import java.util.*;
import java.util.stream.*;

class Solution {
    int row, col;
    String[][] relation;
    Set<String> candidateKey = new HashSet<>();
    
    public int solution(String[][] relation) {
        
        row = relation.length;
        col = relation[0].length;
        this.relation = relation;
        
        for(int i = 1 ; i <= col ; i++) combination(0, col, i, "");
        
        return candidateKey.size();
    }
    
    
    void combination(int idx, int col, int cnt, String res){
        if(res.length() == cnt){
            if(isUnique(res) && isMinimal(res)) candidateKey.add(res);
        }
        for(int i = idx ; i < col ; i++) combination(i + 1, col, cnt, res + i);
    }
    
    boolean isUnique(String res){
        Set<String> set = new HashSet<>();
        for(int i  = 0 ; i < row ; i++){
            StringBuilder sb = new StringBuilder();
            for(char colIdx : res.toCharArray()) sb.append(relation[i][colIdx - '0']).append(",");
            if(!set.add(sb.toString())) return false;
        }
        return true;
    }
    
    boolean isMinimal(String res) {
        for(String key : candidateKey)
            if(isSubSet(key, res)) return false;
        return true; 
    }
    
    boolean isSubSet(String key, String res){
        Set<Character> resSet = res.chars()
            .mapToObj(ch -> (char)ch)
            .collect(Collectors.toSet());
        
        for(char k : key.toCharArray())
            if(!resSet.contains(k)) return false;
        return true;
    }
}