import java.util.*;

class Solution {
    Set<String> candidateKeys = new HashSet<>();
    String[][] relations;
    int colSize, rowSize;
    
    public int solution(String[][] relation) {
        colSize = relation[0].length;
        rowSize = relation.length;
        relations = relation;
        
        for (int i = 1; i <= colSize; i++) {
            combination(0, "", colSize, i);
        }
        
        return candidateKeys.size();
    }
    
    void combination(int idx, String current, int n, int r) {
        if (current.length() == r) {
            if (isUnique(current) && isMinimal(current)) {
                candidateKeys.add(current);
            }
            return;
        }
        
        for (int i = idx; i < n; i++) {
            combination(i + 1, current + i, n, r);
        }
    }
    
    boolean isUnique(String columns) {
        Set<String> uniqueSet = new HashSet<>();
        for (int i = 0; i < rowSize; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : columns.toCharArray()) {
                int col = c - '0';
                sb.append(relations[i][col]).append(",");
            }
            if (!uniqueSet.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
    
    boolean isMinimal(String columns) {
        for (String key : candidateKeys) {
            if (isSubset(key, columns)) {
                return false;
            }
        }
        return true;
    }
    
    boolean isSubset(String key, String columns) {
        Set<Character> columnSet = new HashSet<>();
        for (char c : columns.toCharArray()) {
            columnSet.add(c);
        }
        for (char c : key.toCharArray()) {
            if (!columnSet.contains(c)) {
                return false;
            }
        }
        return true;
    }
}