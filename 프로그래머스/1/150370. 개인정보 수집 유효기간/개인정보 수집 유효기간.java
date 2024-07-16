import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(String term : terms) {
            String[] splitTerm = term.split(" ");
            map.put(splitTerm[0], Integer.valueOf(splitTerm[1]));
        }
        
        int todayDays = convertToDays(today);
        
        for(int i = 0 ; i < privacies.length ; i++) {
            
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String termType = parts[1];
            
            int expirationDays = convertToDays(date) + map.get(termType) * 28;
            
            if(expirationDays <= todayDays)
                result.add(i + 1); 
        }
        
        
        return result.stream().mapToInt(Integer::valueOf)
            .toArray();
        
    }
    
    
    
    int convertToDays(String date) {
        
        String[] splitDate = date.split("\\.");
        int year = Integer.valueOf(splitDate[0]);
        int month = Integer.valueOf(splitDate[1]);
        int day = Integer.valueOf(splitDate[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
        
    }
    
}