import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        TreeSet<Integer> numArr = new TreeSet<>();
        Deque<Integer> removed = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++) numArr.add(i);
        int cur = k;
        
        for(String c : cmd) {
            String[] ops = c.split(" ");
            String op = ops[0];
            
            if(op.equals("D")){
                int cnt = Integer.parseInt(ops[1]);
                while(cnt > 0){
                    cur = numArr.higher(cur);
                    cnt--;
                }
            }else if(op.equals("U")){
                int cnt = Integer.parseInt(ops[1]);
                while(cnt > 0){
                    cur = numArr.lower(cur);
                    cnt--; 
                }
            }else if(op.equals("C")){
                removed.offerLast(cur);
                numArr.remove(cur);
                if(numArr.higher(cur) == null) cur = numArr.lower(cur);
                else cur = numArr.higher(cur);      
            }else if(op.equals("Z")){
                numArr.add(removed.pollLast());
            }
        }
        
        
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int r : removed) sb.setCharAt(r, 'X');
        return sb.toString();
    }
}