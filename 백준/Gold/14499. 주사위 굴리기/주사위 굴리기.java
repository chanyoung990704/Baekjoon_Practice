import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NMxyK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMxyK[0];
        int M = NMxyK[1];
        int y = NMxyK[2];
        int x = NMxyK[3];
        int K = NMxyK[4];

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> operations = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 주사위 평면도
        int[][] dice = new int[4][3];
        int[] dy = new int[]{0,0,-1,1};
        int[] dx = new int[]{1,-1,0,0};

        for (int op : operations) {
            op = op-1;
            int ny = y + dy[op];
            int nx = x + dx[op];

            // 이동 불가능
            if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }

            // 이동
            switch (op) {
                case 0:
                    rightDice(dice);
                    break;
                case 1:
                    leftDice(dice);
                    break;
                case 2:
                    upDice(dice);
                    break;
                case 3:
                    downDice(dice);
                    break;
                default:
                    break;
            }

            // 이동 칸 바닥 확인
            if(map[ny][nx] == 0) {
                map[ny][nx] = dice[3][1];
            }else{
                dice[3][1] = map[ny][nx];
                map[ny][nx] = 0;
            }

            printDice(dice);

            y = ny;
            x = nx;

        }

    }

    static void printDice(int[][] dice) {
        System.out.println(dice[1][1]);
    }

    static void rightDice(int[][] dice) {
        int a = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = a;
    }
    static void leftDice(int[][] dice) {
        int a = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = a;
    }
    static void upDice(int[][] dice) {
        int a = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = a;
    }
    static void downDice(int[][] dice) {
        int a = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = a;
    }
}
