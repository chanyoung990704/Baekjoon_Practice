import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        // 톱니바퀴 담을 리스트
        List<Deque<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> input = Arrays.stream(br.readLine().split(""))
                .map(Integer::valueOf).collect(Collectors.toList());
            list.add(new ArrayDeque<>(input));
        }

        int turn = Integer.valueOf(br.readLine());
        List<List<Integer>> turns = new ArrayList<>();
        for (int i = 0; i < turn; i++) {
            turns.add(Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList()));
        }

        // 회전 진행
        for (List<Integer> cur : turns) {
            int idx = cur.get(0) - 1;
            int dir = cur.get(1);

            // 각 톱니바퀴의 회전 방향 저장 (-1: 반시계, 1: 시계, 0: 회전 없음)
            int[] directions = new int[4];
            directions[idx] = dir;

            // 왼쪽으로 전파
            for (int i = idx - 1; i >= 0; i--) {
                if (list.get(i).toArray()[2] != list.get(i + 1).toArray()[6]) {
                    directions[i] = -directions[i + 1]; // 반대 방향으로 회전
                } else {
                    break; // 맞닿은 극이 같으면 더 이상 전파되지 않음
                }
            }

            // 오른쪽으로 전파
            for (int i = idx + 1; i < 4; i++) {
                if (list.get(i - 1).toArray()[2] != list.get(i).toArray()[6]) {
                    directions[i] = -directions[i - 1]; // 반대 방향으로 회전
                } else {
                    break; // 맞닿은 극이 같으면 더 이상 전파되지 않음
                }
            }

            // 모든 톱니바퀴 회전 실행
            for (int i = 0; i < 4; i++) {
                if (directions[i] == 1) { // 시계 방향 회전
                    list.get(i).offerFirst(list.get(i).pollLast());
                } else if (directions[i] == -1) { // 반시계 방향 회전
                    list.get(i).offerLast(list.get(i).pollFirst());
                }
            }
        }

        int score = 0;
        int idx = 0;
        // 점수 계산
        for (Deque<Integer> dq : list) {
            if (dq.peekFirst() == 1) { // S극이면 점수 추가
                score += (int) Math.pow(2, idx);
            }
            idx++;
        }

        System.out.println(score);
    }
}
