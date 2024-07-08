import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        
        Set<String> vowels = Set.of("a", "e", "i", "o", "u");
        
        return my_string.chars()
                        .mapToObj(c -> (char) c)
                        .map(String::valueOf)
                        .filter(c -> !vowels.contains(c))
                        .collect(Collectors.joining());
        
    }
}