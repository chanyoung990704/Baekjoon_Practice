import java.util.*;

public class Solution {
    public String[] solution(String[][] tickets) {
        // 그래프 구성: 출발지 -> 도착지 리스트
        Map<String, List<String>> graph = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
        }
        
        // 알파벳 순서로 정렬
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        List<String> route = new ArrayList<>();
        route.add("ICN"); // 시작 공항
        
        dfs("ICN", graph, route, tickets.length);
        
        return route.toArray(new String[0]);
    }
    
    private boolean dfs(String current, Map<String, List<String>> graph, List<String> route, int totalTickets) {
        // 모든 항공권을 사용했는지 확인
        if (route.size() == totalTickets + 1) {
            return true;
        }
        
        // 현재 공항에서 출발하는 항공권이 없는 경우
        if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
            return false;
        }
        
        // 현재 공항에서 갈 수 있는 모든 공항 시도
        List<String> destinations = graph.get(current);
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.get(i);
            
            // 해당 항공권 사용 (제거)
            destinations.remove(i);
            
            // 다음 공항 방문
            route.add(next);
            
            // 다음 공항에서 계속 탐색
            if (dfs(next, graph, route, totalTickets)) {
                return true;
            }
            
            // 백트래킹: 방문 취소
            route.remove(route.size() - 1);
            destinations.add(i, next);
        }
        
        return false;
    }
}
