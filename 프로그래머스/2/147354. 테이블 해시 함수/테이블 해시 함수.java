import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 데이터 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col - 1];
        });

        // 각 행에 대한 계산
        List<Integer> list = IntStream.range(1, data.length + 1)
            .map(idx -> Arrays.stream(data[idx - 1])
                .reduce(0, (a, b) -> a + (b % idx)))
            .boxed()
            .collect(Collectors.toList());

        // 주어진 범위의 행들에 대해 XOR 연산 수행
        int result = list.get(row_begin - 1);
        for (int i = row_begin; i < row_end; i++) {
            result ^= list.get(i);
        }

        return result;
    }
}