

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 건물 개수
        int N = Integer.parseInt(br.readLine());

        // 건물 높이
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 보이는 건물 저장
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int[] leftCnt = new int[N + 1];
        // 0번부터 진행
        Deque<int[]> dq = new ArrayDeque<>(); // idx, 높이
        for(int i = 0; i < N; i++) {
            int cur= heights[i];

            // 자기보다 작은 건물들 제거
            while (!dq.isEmpty() && cur >= dq.peekLast()[1]) {
                dq.pollLast();
            }

            // 저장할 수 있으면 저장
            if(!dq.isEmpty()) {
                map.computeIfAbsent(i + 1, k -> new HashSet<>()).add(dq.peekLast()[0] + 1);
                leftCnt[i + 1] = leftCnt[dq.peekLast()[0] + 1] + 1;
            }

            dq.offerLast(new int[]{i, cur});
        }

        dq.clear();
        int[] rightCnt = new int[N + 1];
        // 마지막부터 진행
        for(int i = N - 1; i >= 0; i--) {
            int cur = heights[i];

            //자기보다 작은 거 제거
            while (!dq.isEmpty() && cur >= dq.peekLast()[1]) {
                dq.pollLast();
            }

            // 저장할 수 있으면 저장
            if(!dq.isEmpty()) {
                // 왼쪽에 저장된 거 있으면 거리 비교해서 저장하기
                if(leftCnt[i + 1] > 0){
                    // 이전에 저장된 값 찾기
                    int prev = map.get(i + 1).iterator().next();
                    int c = dq.peekLast()[0] + 1;

                    // 절댓값 비교해서 작은 거 저장
                    int absP = Math.abs(prev - (i + 1));
                    int absC = Math.abs(c - (i + 1));

                    // 이전게 큰 상황
                    if (absP > absC) {
                        map.get(i + 1).remove(prev);
                        map.get(i + 1).add(c);
                    }
                    else if(absP == absC){
                        if(prev > c){
                            map.get(i + 1).remove(prev);
                            map.get(i + 1).add(c);
                        }
                    }

                }else{
                    map.computeIfAbsent(i + 1, k -> new HashSet<>()).add(dq.peekLast()[0] + 1);
                }
                rightCnt[i + 1] = rightCnt[dq.peekLast()[0] + 1] + 1;
            }

            dq.offerLast(new int[]{i, cur});
        }

        for(int i = 1; i <= N; i++) {
            if(map.containsKey(i)) {
                int cnt = leftCnt[i] + rightCnt[i];
                System.out.println(cnt + " " + map.get(i).iterator().next().intValue());
            }else{
                System.out.println(0);
            }
        }

    }
}
