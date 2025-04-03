import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Node{
        String name;
        int price;
        Node parent = null;
        List<Node> children = new ArrayList<>();
        
        Node(String name){
            this.name = name;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // 루트
        Node root = new Node("center");
        Map<String, Node> map = new HashMap<>();
        map.put("-", root);
        
        // 트리 생성
        for(int i = 0 ; i < enroll.length ; i++){
            String e = enroll[i];
            String r = referral[i];
            
            // 맵에 없으면 등록
            if(!map.containsKey(e)){
                map.put(e, new Node(e));
            }
            if(!map.containsKey(r)){
                map.put(r, new Node(r));
            }
            
            // 노드 가져와서 연결
            Node parent = map.get(r);
            Node child = map.get(e);
            
            parent.children.add(child);
            child.parent = parent;
            
        }
        
        // seller - amount 계산
        for(int i = 0 ; i < seller.length ; i++){
            String s = seller[i];
            int a = amount[i] * 100;
            
            Node start = map.get(s);
            
            // 부모가 null일때까지 진행
            while(start.parent != null){
                // 금액 계산
                if(a / 10 < 1){
                    start.price += a;
                    break;
                }
                // 자신에게 90%
                start.price += a - (a / 10);
                a /= 10;
                
                // 다음 부모로 이동
                start = start.parent;
            }
            
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = map.get(enroll[i]).price;
        }
        

        return answer;
    }
}