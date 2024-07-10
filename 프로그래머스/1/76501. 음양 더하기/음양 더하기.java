import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, signs.length)
            .map(i -> {
                if(signs[i])
                    return absolutes[i];
                else
                    return -(absolutes[i]);
            })
            .sum();
    }
}