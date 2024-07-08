import java.util.stream.Collectors;

class Solution {
    public String solution(int age) {
        return String.valueOf(age)
            .chars()
            .mapToObj(i -> String.valueOf((char) (i - '0' + 'a')))
            .collect(Collectors.joining());
            
    }
}