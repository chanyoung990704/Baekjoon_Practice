import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Music{
        String title;
        int playTime;
        int idx;
        
        Music(String title, int playTime, int idx){
            this.title = title;
            this.playTime = playTime;
            this.idx = idx;
        }
        String getTitle(){return title;}
        int getPlayTime(){return playTime;}
        int getIdx(){return idx;}
    }
    
    public String solution(String m, String[] musicinfos) {
        
        PriorityQueue<Music> pq = 
            new PriorityQueue<>(
            Comparator.comparing(Music::getPlayTime).reversed()
            .thenComparing(Comparator.comparing(Music::getIdx))
                               );
        
        int idx = 0;
        
        for(String info : musicinfos) {
            
            String[] cur = info.split(",");
            int start = convertMinute(cur[0]);
            int end = convertMinute(cur[1]);
            String title = cur[2];
            
            // #없애기
            StringBuilder content = new StringBuilder();
            for(int i = 0 ; i < cur[3].length() ; i++){
                if(cur[3].charAt(i) == '#'){
                  content.setCharAt(content.length() - 1,
                    Character.toLowerCase(cur[3].charAt(i - 1)));
                  continue;
                } 
                content.append(cur[3].charAt(i));
                
            }
            
            StringBuilder renewM = new StringBuilder();
            for(int i = 0 ; i < m.length() ; i++){
                if(m.charAt(i) == '#'){
                  renewM.setCharAt(renewM.length() - 1,
                    Character.toLowerCase(m.charAt(i - 1)));
                  continue;
                } 
                renewM.append(m.charAt(i));
                
            }
            
            String finalContent = "";
            
            if(content.length() > end - start) finalContent = content.substring(0, end - start);
            else{
                // 길이만큼 붙이기
                int appendIdx = 0;
                while(content.length() < end - start){
                    content.append(content.charAt(appendIdx++));
                }
                finalContent = content.toString();
            }
            
            
            if(finalContent.contains(renewM.toString())) pq.offer(new Music(title, end - start, idx++));
            
        }
        
        if(!pq.isEmpty()) return pq.peek().getTitle();
        else return "(None)";
    }
    
    
    int convertMinute(String s){
        String[] cur = s.split(":");
        int h = Integer.valueOf(cur[0]);
        int m = Integer.valueOf(cur[1]);
        return h * 60 + m;
    }
}