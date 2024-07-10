import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int n) {
        return IntStream.range(1, n + 1)
            .mapToObj(i -> {
                if(i % 2 == 0) {
                    return "박";
                }else{
                    return "수";
                }
            })
            .collect(Collectors.joining());
    }
}