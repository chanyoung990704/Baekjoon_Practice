import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] lab;
    static int min = 987654321;


    static List<int[]> virusSpace = new ArrayList<>(); // 바이러스 있는 좌표
    static List<int[]> space = new ArrayList<>(); // 빈 공간

    // 상하좌우
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];

        for (int i = 0; i < N; i++) {
            lab[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 0) {
                    // 빈공간
                    space.add(new int[]{i, j});
                } else if (lab[i][j] == 2) {
                    virusSpace.add(new int[]{i, j});
                }
            }
        }

        // 이미 다 감염
        if (space.size() < 1) {
            System.out.println(0);
            return;
        }

        comb(0, new ArrayList<>());

        System.out.println(min == 987654321 ? -1 : min);
    }

    private static void comb(int cur, List<Integer> res) {
        // basecase
        if (res.size() == M) {
            setVirus(res);
            return;
        }

        // 조합
        for (int i = cur; i < virusSpace.size(); i++) {
            res.add(i);
            comb(i + 1, res);
            res.remove(res.size() - 1);
        }
    }

    private static void setVirus(List<Integer> res) {
        // 복사하고
        int[][] cLab = new int[N][N];
        for (int i = 0; i < N; i++) {
            cLab[i] = Arrays.copyOf(lab[i], N);
        }

        // 바이러스 추가
        // BFS 준비
        Queue<int[]> q = new LinkedList<>(); // y, x, 시간,
        boolean[][] visited = new boolean[N][N];
        int remain = space.size();

        for (int r : res) {
            int[] idx = virusSpace.get(r);
            int y = idx[0], x = idx[1];
            cLab[y][x] = 3;
            q.add(new int[]{y, x, 0});
            visited[y][x] = true;
        }

        while (!q.isEmpty()) {
            // 꺼내기
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], time = cur[2];

            // 바이러스 전이
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (!isRound(ny, nx) || visited[ny][nx] || cLab[ny][nx] == 1) continue;

                visited[ny][nx] = true;

                if (cLab[ny][nx] == 0) {
                    remain--;
                    if (remain == 0) {
                        min = Math.min(min, time + 1);
                        return;
                    }
                }

                q.add(new int[]{ny, nx, time + 1});
            }

        }


    }

    private static boolean isRound(int ny, int nx) {
        return ny >= 0 && ny < N && nx >= 0 && nx < N;
    }

}