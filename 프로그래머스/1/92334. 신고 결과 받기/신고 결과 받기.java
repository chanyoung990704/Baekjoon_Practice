import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCnt = new HashMap<>();
        
        // 초기화
        for(String id : id_list){
            reportMap.put(id, new HashSet<>());
            reportCnt.put(id, 0);
        }
        
        // 신고 기록 관리
        for(String rep : report) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            // 신고 처리
            if(reportMap.get(reported).add(reporter)){
                reportCnt.put(reported, reportCnt.get(reported) + 1);
            }
        }
        
        // 정지된 유저 목록
        Set<String> bannedUsers = new HashSet<>();
        for(Map.Entry<String, Integer> entry : reportCnt.entrySet()){
            if(entry.getValue() >= k)
                bannedUsers.add(entry.getKey());
        }
        
        
        return Arrays.stream(id_list).mapToInt(i -> {
            // 
            int cnt = 0;
            for(String reported : reportMap.keySet()){
                if(reportMap.get(reported).contains(i) && 
                   bannedUsers.contains(reported))
                    cnt++;
            }
            
            return cnt;
        }).toArray();
        
        
    }
}