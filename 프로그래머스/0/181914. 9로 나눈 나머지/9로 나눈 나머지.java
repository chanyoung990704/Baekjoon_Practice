import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String number) {
        
        return Arrays.stream(number.split("")).mapToInt(Integer::valueOf)
                .sum() % 9;
    }
}