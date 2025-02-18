import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            graph.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        int time = 0;

        while (true) {
            // 빙산이 다 녹았는지 확인
            boolean isFin = graph.stream().flatMap((List<Integer> i) -> i.stream())
            .allMatch(i -> i == 0);

            if(isFin){
                // 수정: 빙산이 다 녹았으면 0 출력
                time = 0;
                break;
            }
            int[] dy = new int[]{0,0,1,-1};
            int[] dx = new int[]{1,-1,0,0};
            // 분리된 땅 찾기
            int detach = 0;
            boolean[][] visited = new boolean[N][M];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    int val = graph.get(i).get(j);
                    // BFS해야 하면
                    if(!visited[i][j] && val > 0){
                        Deque<List<Integer>> dq = new ArrayDeque<>();
                        visited[i][j] = true;
                        detach++;
                        dq.offer(List.of(i, j));
                        while (!dq.isEmpty()) {
                            List<Integer> cur = dq.pollFirst();
                            for(int dir = 0 ; dir < 4 ; dir++){
                                int ny = cur.get(0) + dy[dir];
                                int nx = cur.get(1) + dx[dir];
                                if(ny >= 0 && ny < N && nx >= 0 && nx < M){
                                    if(!visited[ny][nx] && graph.get(ny).get(nx) > 0){
                                        visited[ny][nx] = true;
                                        dq.offer(List.of(ny,nx));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(detach > 1){
                break;
            }
            
            if(detach == 0) {
                // 수정: 빙산이 없으면 0 출력
                time = 0;
                break;
            }

            time++;
            // 줄어들 칸 찾기
            List<List<Integer>> info = new ArrayList<>(); // <y,x,cnt>
            for(int i = 0 ; i < graph.size() ; i++){
                for(int j = 0 ; j < graph.get(0).size() ; j++){
                    int val = graph.get(i).get(j);
                    if(val > 0){
                        int cnt = 0;
                        for(int dir = 0 ; dir < 4 ; dir++){
                            int ny = i + dy[dir];
                            int nx = j + dx[dir];
                            if(ny >= 0 && ny < graph.size() && nx >= 0 && nx < graph.get(0).size()){
                                if(graph.get(ny).get(nx) == 0){
                                    cnt++;
                                }
                            } 
                        }
                        info.add(List.of(i, j, cnt));
                    }
                }
            }

            // 감소시키기
            for(List<Integer> g : info){
                int y = g.get(0);
                int x = g.get(1);
                int cnt = g.get(2);
                int origin = graph.get(y).get(x);
                graph.get(y).set(x, origin - cnt < 0 ? 0 : origin - cnt);
            }
        }

        System.out.println(time);
    }
}

