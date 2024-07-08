import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                     .map(cur -> {
                         if (cur.equals(cur.toLowerCase())) {
                             return cur.toUpperCase();
                         } else {
                             return cur.toLowerCase();
                         }
                     })
                     .collect(Collectors.joining());
    }
}