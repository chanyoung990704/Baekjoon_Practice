import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽 바꿀 수 있는 경우
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swap(arr, i, j ,i , j + 1);
                    calcRight(arr);
                    calcDown(arr);
                    swap(arr, i, j ,i , j + 1);
                }

                // 아래 바꿀 수 있는 경우
                if(i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swap(arr, i, j, i + 1, j);
                    calcRight(arr);
                    calcDown(arr);
                    swap(arr, i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void calcDown(char[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            char prev = arr[0][i];
            int cnt = 0;
            for(int j = 0 ; j < arr.length ; j++) {
                if(arr[j][i] == prev) {
                    cnt++;
                    continue;
                }
                max = Math.max(max, cnt);
                prev = arr[j][i];
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
    }

    private static void calcRight(char[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            char prev = arr[i][0];
            int cnt = 0;
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == prev) {
                    cnt++;
                    continue;
                }
                max = Math.max(max, cnt);
                prev = arr[i][j];
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
    }

    static void swap(char[][] arr, int y, int x, int y1, int x1) {
        char tmp = arr[y][x];
        arr[y][x] = arr[y1][x1];
        arr[y1][x1] = tmp;
    }
}
