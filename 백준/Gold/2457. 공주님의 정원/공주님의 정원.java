import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 기존 코드 유지 (입력 및 날짜 처리 부분)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        // 날짜 누적 합 (기존 코드 유지)
        int[] days = new int[13];
        for(int i = 1 ; i <= 12 ; i++){
            switch (i) {
                case 4: case 6: case 9: case 11:
                    days[i] = 30;
                    break;
                default:
                    days[i] = 31;
                    break;
            }
        }
        days[2] = 28;

        int[] prefixSum = new int[13];
        for(int i = 1 ; i <= 12 ; i++){
            prefixSum[i] = prefixSum[i - 1] + days[i];
        }

        // Flower 리스트 생성 (시작 날짜 기준으로 정렬로 변경)
        List<Flower> flowers = list.stream().map(i -> {
            int start = prefixSum[i.get(0) - 1] + i.get(1);
            int end = prefixSum[i.get(2) - 1] + i.get(3);
            return new Flower(start, end);
        }).sorted(Comparator.comparing((Flower f) -> f.start))  // 시작 날짜 기준 정렬
        .collect(Collectors.toList());

        // 수정된 탐색 로직
        int current = prefixSum[2] + 1;  // 3월 1일
        int endDate = prefixSum[10] + 30;  // 11월 30일
        int count = 0;
        int idx = 0;

        while (current <= endDate) {
            int maxEnd = current;
            boolean found = false;
            
            // 현재 날짜에서 선택 가능한 꽃 중 가장 늦게 지는 꽃 찾기
            while (idx < flowers.size() && flowers.get(idx).start <= current) {
                if (flowers.get(idx).end > maxEnd) {
                    maxEnd = flowers.get(idx).end;
                    found = true;
                }
                idx++;
            }

            if (!found) {
                count = 0;
                break;
            }

            count++;
            current = maxEnd;
        }

        System.out.println(current > endDate ? count : 0);
    }

    static class Flower { 
        int start;
        int end;

        Flower(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
