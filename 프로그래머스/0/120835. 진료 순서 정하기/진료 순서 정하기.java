import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    // 응급도와 인덱스를 저장할 클래스
    class Emergency {
        int value;
        int index;
        
        Emergency(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public int[] solution(int[] emergency) {
        int[] result = new int[emergency.length];
        AtomicInteger rank = new AtomicInteger(1);
        
        IntStream.range(0, emergency.length)
            .mapToObj(i -> new Emergency(emergency[i], i))
            .sorted(Comparator.comparingInt((Emergency e) -> e.value).reversed())
            .forEach(e -> {
                result[e.index] = rank.getAndIncrement();
            });
        
        return result;
    }
}
