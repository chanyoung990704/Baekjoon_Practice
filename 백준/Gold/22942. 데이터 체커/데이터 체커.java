

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        // 좌표 만들기
        List<int[]> circlesIdx = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++) {
            circlesIdx.add(new int[]{list.get(i)[0] - list.get(i)[1], i});
            circlesIdx.add(new int[]{list.get(i)[0] + list.get(i)[1], i});
        }

        circlesIdx.sort((a, b) -> a[0] - b[0]);
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < circlesIdx.size() ; i++) {
            int idx = circlesIdx.get(i)[1];

            // 자기 자신의 값이 있으면 삭제
            if (!dq.isEmpty() && dq.peekLast() == idx) {
                dq.pollLast();
                continue;
            }

            dq.offerLast(idx);
        }


        System.out.println(dq.isEmpty() ? "YES" : "NO");
    }
}
