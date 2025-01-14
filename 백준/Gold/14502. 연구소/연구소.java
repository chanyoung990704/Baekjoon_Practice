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

        int[][] m = new int[N][M];
        List<int[]> list = new ArrayList<>(); // 빈칸 저장
        for(int i = 0 ; i < N ; i++){
            String[] cur = br.readLine().split(" ");
            for(int j = 0 ; j < cur.length ; j++){
                m[i][j] = Integer.valueOf(cur[j]);
                if(m[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }

        // 3개의 조합 뽑아내기
        List<List<int[]>> comb = new ArrayList<>();
        getComb(list, comb, new ArrayList<>(), 0);
        int max = Integer.MIN_VALUE;

        // 조합 탐색하기
        for(int i = 0 ; i < comb.size() ; i++){
            // 빈칸에 벽을 세워보기
            for(int j = 0 ; j < comb.get(i).size() ; j++){
                int[] cur = comb.get(i).get(j);
                m[cur[0]][cur[1]] = 1;
            }

            // BFS
            max = Math.max(max, bfs(m));

            // 세운 벽 없애기
            for(int j = 0 ; j < comb.get(i).size() ; j++){
                int[] cur = comb.get(i).get(j);
                m[cur[0]][cur[1]] = 0;
            }
        }

        System.out.println(max);
    }

    static int bfs(int[][] org){

        int[][] m = new int[org.length][org[0].length];
        for(int i = 0 ; i < m.length ; i++){
            for(int j = 0 ; j < m[0].length ; j++){
                m[i][j] = org[i][j];
            }
        }

        boolean[][] visited = new boolean[m.length][m[0].length];

        for(int i = 0 ; i < m.length ; i++){
            for(int j = 0 ; j < m[0].length ; j++) {
                int cur = m[i][j];
                // 바이러스이면 BFS 진행
                if(cur == 2 && !visited[i][j]){
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!dq.isEmpty()) {
                        int y = dq.peek()[0];
                        int x = dq.peek()[1];
                        dq.poll();
                        int[] dx = new int[]{0,0,1,-1};
                        int[] dy = new int[]{1,-1,0,0};

                        for(int dir = 0 ; dir < 4 ; dir++){
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];
                            if(ny >= 0 && ny < m.length && nx >= 0 && nx < m[0].length){
                                if(!visited[ny][nx] && m[ny][nx] == 0){
                                    visited[ny][nx] = true;
                                    m[ny][nx] = 1;
                                    dq.offer(new int[]{ny, nx});
                                }
                            }
                        }
                    }

                }
            }
        }

        // 전체 맵에서 안전 영역 몇개인지
        int cnt = 0;
        for(int i = 0 ; i < m.length ; i++){
            for(int j = 0 ; j < m[0].length ; j++){
                if(m[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void getComb(List<int[]> list, List<List<int[]>> comb, List<int[]> visited, int idx){
        if(visited.size() == 3){
            comb.add(new ArrayList<>(visited));
            return;
        }

        for(int i = idx ; i < list.size() ; i++){
            visited.add(list.get(i));
            getComb(list, comb, visited, i + 1);
            visited.remove(visited.size() - 1);
        }
    }
}
