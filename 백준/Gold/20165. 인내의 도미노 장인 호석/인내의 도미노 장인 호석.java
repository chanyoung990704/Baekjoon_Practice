
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NMR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMR[0];
        int M = NMR[1];
        int R = NMR[2];

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] originMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                originMap[i][j] = arr[i][j];
            }
        }

        // 진행
        for (int i = 0; i < R; i++) {
            String[] attack = br.readLine().split(" ");
            String[] defense = br.readLine().split(" ");

            // 공격 먼저 시도
            int y = Integer.valueOf(attack[0]) - 1;
            int x = Integer.valueOf(attack[1]) - 1;

            // 넘어진 도미노가 아닐때 공격
            attackMove(arr, y, x, attack[2]);

            // 수비 세우기
            y = Integer.valueOf(defense[0]) - 1;
            x = Integer.valueOf(defense[1]) - 1;

            if (arr[y][x] == -1) {
                arr[y][x] = originMap[y][x];
            }

        }

        char[][] printMap = new char[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    printMap[i][j] = 'F';
                }else{
                    printMap[i][j] = 'S';
                }
            }
        }

        System.out.println(cnt);

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(printMap[i][j]);
                if(j < M -1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }

    static void attackMove(int[][] arr, int y, int x, String dir) {
        if(arr[y][x] == -1){
            return;
        }

        if (dir.equals("E")) {
            int end = arr[y][x] + x;
            for(int j = x ; j < Math.min(end, arr[0].length) ; j++) {
                // 넘어진 도미노 만났을 때
                if(arr[y][j] == -1) {
                    continue;
                }
                end = Math.max(end, arr[y][j] + j);
                arr[y][j] = -1;
                cnt++;
            }
        }

        if (dir.equals("W")) {
            int start = x - arr[y][x] + 1;
            for(int j = x ; j >= Math.max(0, start) ; j--) {
                if(arr[y][j] == -1) {
                    continue;
                }
                start = Math.min(start, j - arr[y][j] + 1);
                arr[y][j] = -1;
                cnt++;
            }
        }

        if (dir.equals("N")) {
            int start = y - arr[y][x] + 1;
            for(int j = y ; j >= Math.max(0, start) ; j--) {
                if(arr[j][x] == -1) {
                    continue;
                }
                start = Math.min(start, j - arr[j][x] + 1);
                arr[j][x] = -1;
                cnt++;
            }
        }

        if(dir.equals("S")) {
            int end = y + arr[y][x];
            for (int j = y; j < Math.min(end, arr.length); j++) {
                if(arr[j][x] == -1) {
                    continue;
                }
                end = Math.max(end, j + arr[j][x]);
                arr[j][x] = -1;
                cnt++;
            }
        }
    }
}
