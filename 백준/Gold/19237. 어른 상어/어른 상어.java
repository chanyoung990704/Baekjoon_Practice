

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int N, M, k;

    static int[][][] smells; // y, x, 0 -> 상어 번호 , y, x, 1 -> 냄새
    static int[][] sharks; // 상어번호 0 -> y좌표, 상어번호 1 -> x 좌표 상어번호 2 -> 방향
    static int[][][] priorities; // 상어 번호 방향 우선순위
    static boolean[] isAlive; // 상어 생존 여부

    static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NMk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NMk[0];
        M = NMk[1];
        k = NMk[2];

        smells = new int[N][N][2];
        sharks = new int[M + 1][3];
        priorities = new int[M + 1][4][4];
        isAlive = new boolean[M + 1];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (input[j] > 0) {
                    // 상어 입력
                    sharks[input[j]][0] = i;
                    sharks[input[j]][1] = j;
                    isAlive[input[j]] = true;
                    // 냄새
                    smells[i][j][0] = input[j];
                    smells[i][j][1] = k;
                }
            }
        }

        // 방향 입력
        int[] dirs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .map(i -> i - 1).toArray();
        for (int i = 1; i <= M; i++) {
            sharks[i][2] = dirs[i - 1];
        }

        // 우선순위 입력
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                priorities[i][j] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).map(n -> n - 1).toArray();
            }
        }

        // 시뮬레이션
        int time = 0;
        while (time <= 1000) {
            // 1번 상어만 남았는지 확인
            if (onlyFirst()) {
                System.out.println(time);
                return;
            }

            // 모든 상어 이동
            allSharkMove();

            // 냄새 감소
            decreaseSmell();

            // 새 냄새
            addSmell();

            time++;

        }

        System.out.println(-1);

    }

    private static void addSmell() {
        for (int i = 1; i <= M; i++) {
            if (isAlive[i]) {
                int y = sharks[i][0];
                int x = sharks[i][1];
                smells[y][x][0] = i;
                smells[y][x][1] = k;
            }
        }
    }

    private static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smells[i][j][1] > 0) {
                    smells[i][j][1]--;
                    if (smells[i][j][1] == 0) {
                        smells[i][j][0] = 0;
                    }
                }
            }
        }
    }

    private static void allSharkMove() {

        int[][] nextPos = new int[M + 1][3];
        int[][] sharkMap = new int[N][N];

        for (int i = 1; i <= M; i++) {
            // 죽었으면
            if(!isAlive[i]){
                continue;
            }

            int y = sharks[i][0];
            int x = sharks[i][1];
            int dir = sharks[i][2];

            boolean foundEmpty = false;
            boolean foundOwnSmell = false;
            int[] emptySpace = new int[3];
            int[] ownSmellSpace = new int[3];

            // 우선순위 대로 탐색
            for(int d : priorities[i][dir]){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    // 빈칸이면
                    if (smells[ny][nx][1] == 0) {
                        emptySpace[0] = ny;
                        emptySpace[1] = nx;
                        emptySpace[2] = d;
                        foundEmpty = true;
                        break;
                    } else if (!foundOwnSmell && smells[ny][nx][0] == i) {
                        ownSmellSpace[0] = ny;
                        ownSmellSpace[1] = nx;
                        ownSmellSpace[2] = d;
                        foundOwnSmell = true;

                    }
                }
            }

            // 이동
            if(foundEmpty){
                nextPos[i][0] = emptySpace[0];
                nextPos[i][1] = emptySpace[1];
                nextPos[i][2] = emptySpace[2];
            }
            else if(foundOwnSmell){
                nextPos[i][0] = ownSmellSpace[0];
                nextPos[i][1] = ownSmellSpace[1];
                nextPos[i][2] = ownSmellSpace[2];
            }
        }

        // 충돌 처리
        for(int i = 1 ; i <= M; i++) {
            if(!isAlive[i]){
                continue;
            }

            int ny = nextPos[i][0];
            int nx = nextPos[i][1];

            if (sharkMap[ny][nx] == 0) {
                sharkMap[ny][nx] = i;
                sharks[i][0] = ny;
                sharks[i][1] = nx;
                sharks[i][2] = nextPos[i][2];
            }else{
                isAlive[i] = false;
            }
        }
    }

    private static boolean onlyFirst() {
        // 1번은 살아있는지 확인
        if (!isAlive[1]) {
            return false;
        }

        for (int i = 2; i <= M; i++) {
            if(isAlive[i]){
                return false;
            }
        }

        return true;
    }
}
