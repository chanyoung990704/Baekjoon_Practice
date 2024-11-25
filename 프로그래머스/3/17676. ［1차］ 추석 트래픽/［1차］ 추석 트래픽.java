import java.util.*;
class Solution {
    class Node {
        double start;
        double end;
        
        Node(double start, double end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        List<Node> times = new ArrayList<>();
        for(String line : lines) {
            String[] arr = line.split(" ");
            String[] t = arr[1].split(":");
            
            double endTime = Double.valueOf(t[0]) * 3600 +
                           Double.valueOf(t[1]) * 60 +
                           Double.valueOf(t[2]);
            
            double duration = Double.valueOf(arr[2].substring(0, arr[2].length() - 1));
            
            double startTime = endTime - duration + 0.001;
            times.add(new Node(startTime, endTime));
        }
        
        int maxCount = 0;
        
        for(Node time : times){
            int startCnt = 0;
            int endCnt = 0;
            double start = time.start;
            double startPlus = time.start + 1;
            double end = time.end;
            double endPlus = time.end + 1;
            
            for(Node t : times){
                if(t.end >= start && t.start < startPlus ) startCnt++;
                if(t.end >= end && t.start < endPlus) endCnt++;
                
                maxCount = Math.max(maxCount, Math.max(startCnt, endCnt));
            }
        }
        
        return maxCount;
    }
}