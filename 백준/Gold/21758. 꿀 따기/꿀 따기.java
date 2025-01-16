import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        // 누적합
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        for(int n : list){
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + n);
        }

        // 벌통이 중간에 있을 경우
        int mid = Integer.MIN_VALUE;

        for(int i = 1 ; i < list.size() - 1 ; i++){
            // 현재 벌통 위치
            int cur = i + 1;
            int curVal = 0;

            // 2부터 현재 벌통 위치까지 + 현재 벌통 위치 부터 마지막 위치까지
            curVal += prefixSum.get(cur) - prefixSum.get(1);
            curVal += prefixSum.get(list.size() - 1) - prefixSum.get(cur - 1);

            mid = Math.max(mid, curVal);
        }

        // 벌통이 맨 왼쪽에 있는 경우
        int left = Integer.MIN_VALUE;
        int leftBase = prefixSum.get(prefixSum.size() - 2); // 벌이 맨 오른쪽에 있어야 함
        // 나머지 벌이 위치하는 경우
        for(int i = list.size() - 2 ; i >= 1 ; i--){
            // 현재 벌통 위치
            int cur = i + 1;
            int curVal = leftBase;

            // 시작점 0부터 현재 벌통 이전까지 누적합
            curVal += prefixSum.get(cur - 1);
            // 현재 위치는 건너뛰기
            curVal -= list.get(i);

            left = Math.max(left, curVal);
        }

        // 벌통이 맨 오른쪽에 있는 경우
        int right = Integer.MIN_VALUE;
        int rightBase = prefixSum.get(prefixSum.size() - 1) - prefixSum.get(1);
        // 나머지 벌 위치
        for(int i = 1 ; i < list.size() - 1 ; i++) {
            int cur = i + 1;
            int curVal = rightBase;

            // 현재 벌통 다음 위치부터 마지막까지 누적합
            curVal += prefixSum.get(prefixSum.size() - 1) - prefixSum.get(cur);
            // 현재 위치는 건너뒤기
            curVal -= list.get(i);

            right = Math.max(right, curVal);
        }
  
        int res = Math.max(mid, Math.max(left, right));
        System.out.println(res);
    }
}
