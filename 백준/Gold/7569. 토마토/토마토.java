import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> MNH = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

        int M = MNH.get(0); // width
        int N = MNH.get(1); // height
        int H = MNH.get(2); // depth

        // 3차원 그래프를 2차원 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N * H ; i++){
            graph.add(Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList()));
        }

        // BFS
        Deque<List<Integer>> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N * H][M];
        
        // 익은 토마토 찾기
        for(int i = 0 ; i < graph.size() ; i++){
            for(int j = 0 ; j < graph.get(i).size() ; j++){
                if(graph.get(i).get(j) == 1){
                    dq.offer(List.of(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int res = -1;
        // 상하좌우앞뒤 6방향
        int[] dy = {0, 0, 1, -1, N, -N}; 
        int[] dx = {1, -1, 0, 0, 0, 0};

        while (!dq.isEmpty()) {
            List<Integer> cur = dq.pollFirst();
            int y = cur.get(0);
            int x = cur.get(1);
            int day = cur.get(2);

            res = Math.max(res, day);
            graph.get(y).set(x, 1);

            for(int i = 0 ; i < 6 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 같은 층에서의 이동인 경우 (상하좌우)
                if(i < 4) {
                    // 같은 층 내에서만 이동 가능
                    if(ny / N != y / N) continue;
                }
                
                // 전체 범위 체크
                if(ny >= 0 && ny < N * H && nx >= 0 && nx < M){
                    // 방문 가능하고 익지 않은 토마토인 경우
                    if(!visited[ny][nx] && graph.get(ny).get(nx) == 0){
                        visited[ny][nx] = true;
                        dq.offer(List.of(ny, nx, day + 1));
                    }
                }
            }
        }
        
        // 모든 토마토가 익었는지 확인
        System.out.println(isAll(graph) ? res : -1);
    }

    static boolean isAll(List<List<Integer>> graph){
        return graph.stream()
            .flatMap(List::stream)
            .noneMatch(x -> x == 0);
    }
}
