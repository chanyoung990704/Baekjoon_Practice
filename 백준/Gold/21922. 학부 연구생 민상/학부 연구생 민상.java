
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().replaceAll(" ","").toCharArray();
        }

        // 모든 에어컨(9) 찾아서 BFS 시작점으로 추가
        boolean[][][] visited = new boolean[N][M][4];
        Deque<List<Integer>> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '9') {
                    // 에어컨 위치는 모든 방향 방문 처리
                    Arrays.fill(visited[i][j], true);

                    // 4방향으로 BFS 시작
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                            int dir = k;
                            if (arr[ny][nx] - '0' >= 1 && arr[ny][nx] - '0' <= 4) {
                                dir = moveDir(arr, ny, nx, dir);
                            }
                            dq.offer(List.of(ny, nx, dir));
                            visited[ny][nx][dir] = true;
                        }
                    }
                }
            }
        }

        // bfs 진행하면서
        while (!dq.isEmpty()) {
            List<Integer> cur = dq.pollFirst();
            int cy = cur.get(0);
            int cx = cur.get(1);
            int cdir = cur.get(2);

            int ny = cy + dy[cdir];
            int nx = cx + dx[cdir];

            if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (arr[ny][nx] - '0' >= 1 && arr[ny][nx] - '0' <= 4) {
                    cdir = moveDir(arr, ny, nx, cdir);
                }
                if (!visited[ny][nx][cdir]) {
                    visited[ny][nx][cdir] = true;
                    dq.offer(List.of(ny, nx, cdir));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean isWind = false;
                for(int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) {
                        isWind = true;
                        break;
                    }
                }
                if (isWind) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static int moveDir(char[][] arr, int y, int x, int dir) {

        switch (arr[y][x]) {
            case '1':
                if(dir == 2){
                    dir = 3;
                } else if (dir == 3) {
                    dir = 2;
                }
                break;
                case '2':
                    if (dir == 0) {
                        dir = 1;
                    }else if(dir == 1){
                        dir = 0;
                    }
                    break;
                    case '3':
                        if (dir == 1) {
                            dir = 2;
                        } else if (dir == 3) {
                            dir = 0;
                        } else if (dir == 2) {
                            dir = 1;
                        } else if (dir == 0) {
                            dir = 3;
                        }
                        break;
                        case '4':
                            if (dir == 0) {
                                dir = 2;
                            } else if (dir == 1) {
                                dir = 3;
                            } else if (dir == 2) {
                                dir = 0;
                            } else if (dir == 3) {
                                dir = 1;
                            }
                            break;
            default:
        }

        return dir;
    }
}
