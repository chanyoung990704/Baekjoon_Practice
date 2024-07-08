import java.util.stream.IntStream;

class Solution {
    public int solution(int hp) {
        return IntStream.of(hp / 5, (hp % 5) / 3, hp % 5 % 3).sum();
    }
}