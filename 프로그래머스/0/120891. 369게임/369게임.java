import java.util.Arrays;

class Solution {
    public int solution(int order) {
        return (int)Arrays.stream(String.valueOf(order).split(""))
            .filter(i -> {
                return i.equals("3") || i.equals("6") || i.equals("9");
            })
            .count();
    }
}