import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        // id 닉네임 맵
        Map<String, String> userInfo = new HashMap<>();
        List<String> logs = new ArrayList<>();
        
        for(String log : record) {
            String[] part = log.split(" ");
            String op = part[0];
            String id = part[1];
            
            // 닉네임 변경
            if(op.equals("Enter") || op.equals("Change")) {
                String nickname = part[2];
                userInfo.put(id, nickname);
            }
        }
        
        for(String log : record) {
            String[] part = log.split(" ");
            String op = part[0];
            String id = part[1];
            
            if(op.equals("Enter")) {
                logs.add(userInfo.get(id) + "님이 들어왔습니다.");
            } else if(op.equals("Leave")) {
                logs.add(userInfo.get(id) + "님이 나갔습니다.");
            }
        }
        
        return logs.stream().toArray(String[]::new);
    }
}