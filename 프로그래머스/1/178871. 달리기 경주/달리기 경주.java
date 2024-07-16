import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> playerRank = new HashMap<>();
        Map<Integer, String> rankPlayer = new HashMap<>();
        
        for(int i = 0 ; i < players.length ; i++){
            playerRank.put(players[i], i);
            rankPlayer.put(i, players[i]);
        }
        
        for(String calling : callings) {
            
            int curRank = playerRank.get(calling);
            int newRank = curRank - 1;
            String prevPlayer = rankPlayer.get(newRank);
            
            rankPlayer.put(newRank, calling);
            rankPlayer.put(curRank, prevPlayer);
            
            playerRank.put(calling, newRank);
            playerRank.put(prevPlayer, curRank);      
            
        }
        
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < players.length ; i++)
            result.add(rankPlayer.get(i));
        
        return result.stream().toArray(String[]::new);
        
    }
}