import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    int n;
    int[][] build_frame;
    Map<String, Boolean> gi = new HashMap<>(); // 기둥
    Map<String, Boolean> bo = new HashMap<>(); // 보
        
    public int[][] solution(int n, int[][] build_frame) {
        
   
        this.n = n;
        this.build_frame = build_frame;
        
        for(int[] bf : build_frame){
            int x = bf[0];
            int y = bf[1];
            int a = bf[2];
            int b = bf[3];
            String key = String.valueOf(x) + " " + String.valueOf(y);
            // 설치
            if(b == 1){
                if(a == 0){
                    gi.put(key, true);
                    if(!possibleGi()){
                        gi.remove(key);
                    }
                }else{
                    bo.put(key, true);
                    if(!possibleBo()){
                        bo.remove(key);
                    }
                }
            }
            else if(b == 0){ // 삭제 시
                if(a == 0){
                    gi.remove(key);
                    if(!possibleGi() || !possibleBo()){ // 둘 다 검사
                        gi.put(key, true);
                    }
                }else{
                    bo.remove(key);
                    if(!possibleGi() || !possibleBo()){ // 둘 다 검사
                        bo.put(key, true);
                    }
                }                
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<String, Boolean> e : gi.entrySet()){
            List<Integer> list = Arrays.stream(e.getKey().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
            list.add(0);
            res.add(list);
        }
        for(Map.Entry<String, Boolean> e : bo.entrySet()){
            List<Integer> list = Arrays.stream(e.getKey().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
            list.add(1);
            res.add(list);
        }   
        
        res.sort(Comparator.comparing((List<Integer> l) -> l.get(0))
                .thenComparing((List<Integer> l) -> l.get(1))
                .thenComparing((List<Integer> l) -> l.get(2)));
        
        return res.stream().map(l -> l.stream().mapToInt(Integer::valueOf).toArray())
            .toArray(int[][]::new);
    }
    
    boolean possibleGi(){
        
        // 기둥 확인
        for(Map.Entry<String, Boolean> e : gi.entrySet()) {
            String[] key = e.getKey().split(" ");
            boolean isPossible = false;
            // 기둥이 바닥에 있을 때
            if(key[1].equals("0")){
                isPossible = true;
            }
            
            // 기둥이 다른 기둥 위에 있을 때
            int y = Integer.valueOf(key[1]) - 1;
            String newKey = key[0] + " " + String.valueOf(y);
            if(gi.containsKey(newKey)){
                isPossible = true;
            }
            
            // 보의 한쪽 끝 부분 위에 있는 경우
            int x = Integer.valueOf(key[0]) - 1;
            String newBoKey = String.valueOf(x) + " " + key[1];
            if(bo.containsKey(newBoKey) || bo.containsKey(e.getKey())){
                isPossible = true;
            }
            
            if(!isPossible){
                return false;
            }
        }
        
        return true;
    }
    
    boolean possibleBo(){
        for(Map.Entry<String, Boolean> e : bo.entrySet()) {
            String[] key = e.getKey().split(" ");
            boolean isPossible = false;
            
            // 한 쪽 끝 부분이 기둥 위
            int y = Integer.valueOf(key[1]);
            int x = Integer.valueOf(key[0]);
            
            String newKeyFirst = String.valueOf(x) + " " + String.valueOf(y - 1);
            String newKeySecond = String.valueOf(x + 1) + " " + String.valueOf(y - 1);
            
            if(gi.containsKey(newKeyFirst) || gi.containsKey(newKeySecond)){
                isPossible = true;
            }
            
            // 양 쪽 끝 부분이 다른 보와 동시에 연결
            String newkeyFirsts = String.valueOf(x - 1) + " " + String.valueOf(y);
            String newKeySeconds = String.valueOf(x + 1) + " " + String.valueOf(y);
            
            if(bo.containsKey(newkeyFirsts) && bo.containsKey(newKeySeconds)){
                isPossible = true;
            }
            
            if(!isPossible){
                return false;
            }
        }
        return true;
    }
}