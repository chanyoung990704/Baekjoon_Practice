import java.util.Set;
import java.util.Arrays;

class Solution {
    public int solution(String[] s1, String[] s2) {
    
        Set<String> set = Set.of(s1);    
        
        return (int)Arrays.stream(s2)
            .filter(set::contains)
            .count();
    }
}