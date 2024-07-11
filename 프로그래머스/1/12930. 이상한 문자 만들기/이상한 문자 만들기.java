import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" ", -1))
            .map(word -> IntStream.range(0, word.length())
                .mapToObj(i -> i % 2 == 0 ? 
                    Character.toUpperCase(word.charAt(i)) : 
                    Character.toLowerCase(word.charAt(i)))
                .map(String::valueOf)
                .collect(Collectors.joining()))
            .collect(Collectors.joining(" "));
    }
}