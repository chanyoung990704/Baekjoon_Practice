import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] RC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = RC[0];
        int C =  RC[1];

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 지훈이 위치 찾기
        int y = 0;
        int x = 0;

        // 불 위치 찾기
        Queue<int[]> fires = new LinkedList<>();

        int[][] fireCnt = new  int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireCnt[i], -1);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'J'){
                    y = i;
                    x= j;
                } else if (map[i][j] == 'F') {
                    fires.add(new int[]{i, j, 0});
                    fireCnt[i][j] = 0;
                }
            }
        }

        // 방향 좌표
        int[] dy = new int[]{1,-1,0,0};
        int[] dx = new int[]{0,0,1,-1};

        // 불 먼저 BFS
        while (!fires.isEmpty()) {
            int[] cur =  fires.poll();
            int curY =  cur[0];
            int curX = cur[1];
            int cnt = cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                if (ny >= 0 && ny < R && nx >= 0 && nx < C && fireCnt[ny][nx] == -1 && map[ny][nx] != '#') {
                    fireCnt[ny][nx] = cnt + 1;
                    fires.add(new int[]{ny, nx, cnt+1});
                }
            }
        }

        // 지훈이 BFS
        Queue<int[]> q =  new LinkedList<>();
        q.offer(new int[]{y, x, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            int cnt =  cur[2];

            if(curY == 0 || curY == R-1 || curX == 0 || curX == C-1){
                System.out.println(cnt+1);
                return;
            }

            for(int i = 0; i < 4; i++){
                int ny =  curY + dy[i];
                int nx =  curX + dx[i];
                if(ny >= 0 && ny < R && nx >= 0 &&  nx < C && map[ny][nx] == '.') {
                    if(fireCnt[ny][nx] == -1 || fireCnt[ny][nx] > cnt+1){
                        map[ny][nx] = 'J';
                        q.add(new int[]{ny,nx,cnt+1});
                    }
                }
            }
        }


        System.out.println("IMPOSSIBLE");

    }

}
