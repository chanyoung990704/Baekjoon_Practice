import java.util.Arrays;
class Solution {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
            .map(i -> i.length())
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}