import java.util.*;
import java.util.stream.*;

class Solution {
    
    Map<String, String> parent = new HashMap<>();
    Set<String> nodes = new HashSet<>();
    Set<String> edges = new HashSet<>();
    
    String findParent(String node){
        if(!parent.containsKey(node)){
            parent.put(node, node);
            return node;
        }
        if(!parent.get(node).equals(node)){
            parent.put(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }
    
    void unionParent(String n1, String n2){
        String r1 = findParent(n1);
        String r2 = findParent(n2);
        
        if(r1.compareTo(r2) < 0){
            parent.put(r2, r1);
        }else{
            parent.put(r1, r2);
        }
    }
    
    public int solution(int[] arrows) {
        
        int[] dy = new int[]{1,1,0,-1,-1,-1,0,1};
        int[] dx = new int[]{0,1,1,1,0,-1,-1,-1};
        
        int y = 0;
        int x = 0;
        
        int cnt = 0;
        
        for(int i = 0 ; i < arrows.length ; i++){
            for(int j = 0; j < 2; j++) {  // 각 이동을 두 단계로 나눔
                int ny = y + dy[arrows[i]];
                int nx = x + dx[arrows[i]];
                
                String cur = y + " " + x;
                String next = ny + " " + nx;
                String edge = cur + "->" + next;
                
                if(nodes.contains(next) && !edges.contains(edge)){
                    if(findParent(cur).equals(findParent(next))){
                        cnt++;
                    }
                }
                
                nodes.add(cur);
                nodes.add(next);
                edges.add(edge);
                edges.add(next + "->" + cur);
                unionParent(cur, next);
                
                y = ny;
                x = nx;
            }
        }
        
        return cnt;
    }
}
