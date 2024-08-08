import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Food{
        int cnt;
        String cur;
        
        Food(int cnt, String cur){
            this.cnt = cnt;
            this.cur = cur;
        }
        int getCnt(){return cnt;}
        String getCur(){return cur;}
    }
    
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        Set<Character> set = new TreeSet<>();
        for(String order : orders)
            for(char c : order.toCharArray()) set.add(c);
        
        String total = set.stream()
            .map(i -> String.valueOf(i))
            .collect(Collectors.joining());
                
        for(int c : course){
            PriorityQueue<Food> pq = 
                new PriorityQueue<>(Comparator.comparing(Food::getCnt).reversed());
            comb(0, total, "", c, orders, pq);
            
            int max = 0;
            if(!pq.isEmpty()) max = pq.peek().getCnt();
            while(!pq.isEmpty() && max == pq.peek().getCnt()){
                result.add(pq.poll().getCur());
            }
        }
        
        return result.stream()
            .sorted()
            .toArray(String[]::new);
        
    }
    
    void comb(int idx, String s, String res, int c, String[] orders
             ,PriorityQueue<Food> pq){
        if(res.length() == c){
            int cur = 0;
            for(String order : orders){
                boolean isPossible = true;
                for(char ch : res.toCharArray()){
                    String cs = String.valueOf(ch);
                    if(!order.contains(cs)){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) cur++;
            }
            
            if(cur >= 2) pq.offer(new Food(cur, res));
            return;
        }
        
        for(int i = idx ; i < s.length() ; i++)
            comb(i + 1, s, res + String.valueOf(s.charAt(i)), c, orders, pq);
    }
}