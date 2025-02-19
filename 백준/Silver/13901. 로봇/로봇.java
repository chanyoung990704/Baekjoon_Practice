import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        // 방 크기 입력
        List<Integer> RC = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int R = RC.get(0);
        int C = RC.get(1);

        // 장애물 개수 입력
        int k = Integer.valueOf(br.readLine());

        // 장애물 위치 입력
        List<List<Integer>> blocks = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            blocks.add(
                Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 시작 위치 입력
        List<Integer> start = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        // 이동 방향 입력
        List<Integer> dir = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        // 그래프 초기화 (0: 미방문, 1: 장애물, -1: 방문)
        int[][] graph = new int[R][C];
        for (List<Integer> block : blocks) {
            int y = block.get(0);
            int x = block.get(1);
            graph[y][x] = 1; // 장애물 표시
        }

        // 방향 벡터 (상, 하, 좌, 우)
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        // 로봇의 시작 위치
        int sy = start.get(0);
        int sx = start.get(1);

        // 현재 방향 인덱스
        int moveIdx = 0;

        while (true) {
            boolean moved = false;

            for (int i = 0; i < 4; i++) { // 최대 4방향 탐색
                int ny = sy + dy[dir.get(moveIdx) - 1];
                int nx = sx + dx[dir.get(moveIdx) - 1];

                // 이동 가능 여부 확인
                if (ny >= 0 && ny < R && nx >= 0 && nx < C 
                        && graph[ny][nx] == 0) { // 미방문 지역만 이동 가능
                    graph[sy][sx] = -1; // 현재 위치 방문 처리
                    sy = ny;
                    sx = nx;
                    moved = true;
                    break;
                }

                // 다음 방향으로 전환
                moveIdx = (moveIdx + 1) % 4;
            }

            if (!moved) { // 더 이상 이동할 수 없는 경우 종료
                break;
            }
        }

        System.out.println(sy + " " + sx);
    }
}

