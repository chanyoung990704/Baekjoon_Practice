import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 매핑
        Map<String, Integer> dailyLook = new HashMap<>();
        for (String[] c : clothes) {
            dailyLook.put(c[1], dailyLook.getOrDefault(c[1], 0) + 1);
        }

        // 모든 종류의 의상 수를 곱하여 조합의 수를 계산
        int combinations = dailyLook.values()
            .stream()
            .map(count -> count + 1) // 각 종류별 의상을 입지 않는 경우를 포함
            .reduce(1, (a, b) -> a * b);

        // 아무것도 입지 않는 경우를 제외
        return combinations - 1;
    }
}