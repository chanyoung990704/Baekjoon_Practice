import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        TreeSet<Integer> activeRows = new TreeSet<>();
        Stack<Integer> removedIndices = new Stack<>();
        
        // 초기화: 모든 행을 활성 상태로 추가
        for (int i = 0; i < n; i++) {
            activeRows.add(i);
        }
        
        int currentIndex = k;
        
        for (String command : cmd) {
            String[] parts = command.split(" ");
            String operation = parts[0];
            
            if (operation.equals("U")) {
                int x = Integer.parseInt(parts[1]);
                while (x > 0) {
                    currentIndex = activeRows.lower(currentIndex);
                    x--;
                }
            } else if (operation.equals("D")) {
                int x = Integer.parseInt(parts[1]);
                while (x > 0) {
                    currentIndex = activeRows.higher(currentIndex);
                    x--;
                }
            } else if (operation.equals("C")) {
                removedIndices.push(currentIndex);
                activeRows.remove(currentIndex);
                
                // 다음 인덱스 설정
                if (activeRows.higher(currentIndex) != null) {
                    currentIndex = activeRows.higher(currentIndex);
                } else {
                    currentIndex = activeRows.lower(currentIndex);
                }
            } else if (operation.equals("Z")) {
                int restoredIndex = removedIndices.pop();
                activeRows.add(restoredIndex);
            }
        }
        
        StringBuilder result = new StringBuilder("O".repeat(n));
        while (!removedIndices.isEmpty()) {
            result.setCharAt(removedIndices.pop(), 'X');
        }
        
        return result.toString();
    }
}