import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            arr.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 일자 리스트로 만들기
        List<Integer> list = arr.stream()
        .flatMap(i -> i.stream()).collect(Collectors.toList());

        // 더미 값 0
        list.add(0,0);

        // 누적합 구하기
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        for(int i = 1 ; i < list.size() ; i++){
            prefixSum.add(prefixSum.get(i - 1) + list.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++) {
            List<Integer> search = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            int x1 = search.get(0);
            int y1 = search.get(1);
            int x2 = search.get(2);
            int y2 = search.get(3);

            int sum = 0;
            // 각 행별로 구간 합을 계산
            for(int row = x1; row <= x2; row++) {
                // 현재 행의 시작과 끝 인덱스 계산
                int startIdx = (row - 1) * N + y1;
                int endIdx = (row - 1) * N + y2;
                sum += prefixSum.get(endIdx) - prefixSum.get(startIdx - 1);
            }
            
            sb.append(sum).append('\n');
        }
        
        System.out.print(sb);
    }
}
