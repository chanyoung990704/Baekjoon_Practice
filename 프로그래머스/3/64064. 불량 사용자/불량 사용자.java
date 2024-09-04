import java.util.*;
import java.util.stream.*;

class Solution {
    String[] user_id;
    String[] banned_id;
    int cnt = 0;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        combination(new ArrayList<>(), 0);
        
        return cnt;
    }
    
    void combination(List<String> result, int idx) {
        if(result.size() == banned_id.length){
            if(permutation(result, new ArrayList<>(), new boolean[result.size()])) cnt++;
            return;
        }
        for(int i = idx ; i < user_id.length ; i++){
            result.add(user_id[i]);
            combination(result, i + 1);
            result.remove(result.size() - 1);
        }
    }
    
    boolean permutation(List<String> result, List<String> cur, boolean[] visited){
        
        if(cur.size() == result.size()) {
            // 순서와 banned_id가 일치하면
            if(equalBan(cur)) return true;
            return false;
        }
        
        for(int i = 0 ; i < result.size() ; i++)
            if(!visited[i]){
                visited[i] = true;
                cur.add(result.get(i));
                if(permutation(result, cur, visited)) return true;
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        
        return false;
    }
    
    boolean equalBan(List<String> users) {
        
        for(int i = 0 ; i < users.size() ; i++) {
            String user = users.get(i);
            String ban = banned_id[i];
            if(user.length() != ban.length()) return false;
            for(int j = 0 ; j < user.length() ; j++){
                char u = user.charAt(j);
                char b = ban.charAt(j);
                if(b != '*' && b != u) return false;
            }
        }
        
        return true;
    }
}