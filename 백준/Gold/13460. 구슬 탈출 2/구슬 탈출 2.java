

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }


        System.out.println(bfs(map));
    }
    static int bfs(char[][] map) {
        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1,-1,0,0};

        int ry = 0; int rx = 0; int by = 0; int bx = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                }else if(map[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        // BFS
        boolean[][][][] visited = new boolean[map.length][map[0].length][map.length][map[0].length];
        Deque<List<Integer>> dq = new ArrayDeque<>();
        visited[ry][rx][by][bx] = true;
        dq.offer(List.of(ry, rx, by, bx, 0));

        while (!dq.isEmpty()) {
            List<Integer> cur = dq.poll();
            int cnt = cur.get(4);
            if(cnt >= 10){
                break;
            }

            for (int i = 0; i < 4; i++) {
                // 빨간 공 이동
                int nry = cur.get(0);
                int nrx = cur.get(1);
                int rcnt = 0;
                while (map[nry + dy[i]][nrx + dx[i]] != '#'){
                    if(map[nry][nrx] == 'O'){
                        break;
                    }
                    rcnt++;
                    nry += dy[i];
                    nrx += dx[i];
                }

                // 검은 공 이동
                int nby = cur.get(2);
                int nbx = cur.get(3);
                int bcnt = 0;
                while (map[nby + dy[i]][nbx + dx[i]] != '#'){
                    if(map[nby][nbx] == 'O'){
                        break;
                    }
                    bcnt++;
                    nby += dy[i];
                    nbx += dx[i];
                }

                if (map[nby][nbx] == 'O') {
                    continue;
                }

                if(map[nry][nrx] == 'O'){
                    return cnt + 1;
                }

                if (nby == nry && nbx == nrx) {
                    if(bcnt < rcnt){
                        nry -= dy[i];
                        nrx -= dx[i];
                    }else{
                        nby -= dy[i];
                        nbx -= dx[i];
                    }
                }

                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    dq.offer(List.of(nry, nrx, nby, nbx, cnt + 1));
                }

            }

        }

        return  -1;
    }
}
