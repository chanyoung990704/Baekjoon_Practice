import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Pipe{
        int[] y;
        int[] x;

        public Pipe(int[] y, int[] x) {
            this.y = y;
            this.x = x;
        }

        boolean isHorizontal(){
            return y[0] == y[1];
        }

        boolean isVertical(){
            return x[0] == x[1];
        }

        boolean isDiagonal(){
            return !isHorizontal() && !isVertical();
        }
    }

    static int[][][] memo; // 메모이제이션 배열 추가

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 메모이제이션 배열 초기화
        memo = new int[N][N][3];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }

        // 초기 파이프
        Pipe pipe = new Pipe(new int[]{0, 0}, new int[]{0, 1});

        System.out.println(solve(map, pipe));
    }
    private static int solve(int[][] map, Pipe pipe) {
        // base case - 목적지 도달 확인
        int N = map.length;
        if(pipe.y[1] == N-1 && pipe.x[1] == N-1){
            return 1;
        }

        // 메모이제이션 체크
        int y = pipe.y[1];  // 파이프의 끝점
        int x = pipe.x[1];
        int dir = pipe.isHorizontal() ? 0 : (pipe.isVertical() ? 1 : 2);

        if(memo[y][x][dir] != -1){
            return memo[y][x][dir];
        }

        int result = 0;

        if(pipe.isHorizontal()){
            result += moveHorizontal(map, pipe);
        }else if(pipe.isVertical()){
            result += moveVertical(map, pipe);
        }else if(pipe.isDiagonal()){
            result += moveDiagonal(map, pipe);
        }

        return memo[y][x][dir] = result;
    }
    private static int moveHorizontal(int[][] map, Pipe pipe) {
        int result = 0;

        // 오른쪽으로 이동 (수평 유지)
        int y1 = pipe.y[0];
        int y2 = pipe.y[1];
        int x1 = pipe.x[0] + 1;
        int x2 = pipe.x[1] + 1;

        if(isBound(y1, x1, map.length) && isBound(y2, x2, map.length)){
            if(map[y1][x1] == 0 && map[y2][x2] == 0){
                Pipe pipe1 = new Pipe(new int[]{y1, y2}, new int[]{x1, x2});
                result += solve(map, pipe1);
            }
        }

        // 대각선으로 이동
        int y3, x3;
        int y4, x4;
        if(pipe.x[0] < pipe.x[1]){
            y3 = pipe.y[0];
            x3 = pipe.x[0] + 1;
            y4 = pipe.y[1] + 1;
            x4 = pipe.x[1] + 1;
        }else{
            y3 = pipe.y[1];
            x3 = pipe.x[1] + 1;
            y4 = pipe.y[0] + 1;
            x4 = pipe.x[0] + 1;
        }

        if(isBound(y3, x3, map.length) && isBound(y4, x4, map.length)){
            if(map[y4][x4] == 0 && map[y4-1][x4] == 0 && map[y4][x4-1] == 0){
                Pipe pipe2 = new Pipe(new int[]{y3, y4}, new int[]{x3, x4});
                result += solve(map, pipe2);
            }
        }

        return result;
    }
    private static int moveVertical(int[][] map, Pipe pipe) {
        int result = 0;

        // 아래로 이동 (수직 유지)
        int y1 = pipe.y[0] + 1;
        int x1 = pipe.x[0];
        int y2 = pipe.y[1] + 1;
        int x2 = pipe.x[1];

        if(isBound(y1, x1, map.length) && isBound(y2, x2, map.length)){
            if(map[y1][x1] == 0 && map[y2][x2] == 0){
                Pipe pipe1 = new Pipe(new int[]{y1, y2}, new int[]{x1, x2});
                result += solve(map, pipe1);
            }
        }

        // 대각선으로 이동
        int y3, x3;
        int y4, x4;
        if(pipe.y[0] < pipe.y[1]){
            y3 = pipe.y[0] + 1;
            y4 = pipe.y[1] + 1;
            x3 = pipe.x[0];
            x4 = pipe.x[1] + 1;
        }else{
            y3 = pipe.y[0] + 1;
            y4 = pipe.y[1] + 1;
            x4 = pipe.x[0] + 1;
            x3 = pipe.x[1];
        }

        if(isBound(y3, x3, map.length) && isBound(y4, x4, map.length)){
            if(map[y4][x4] == 0 && map[y4][x4-1] == 0 && map[y4-1][x4] == 0){
                Pipe pipe2 = new Pipe(new int[]{y3, y4}, new int[]{x3, x4});
                result += solve(map, pipe2);
            }
        }

        return result;
    }
    private static int moveDiagonal(int[][] map, Pipe pipe) {
        int result = 0;
        int y3,y4;
        int x3,x4;

        if(pipe.y[0] < pipe.y[1]){
            y3 = pipe.y[0];
            x3 = pipe.x[0];
            y4 = pipe.y[1];
            x4 = pipe.x[1];
        }else{
            y3 = pipe.y[1];
            x3 = pipe.x[1];
            y4 = pipe.y[0];
            x4 = pipe.x[0];
        }

        // 수평으로 이동
        int y5,x5;
        y5 = y4;
        x5 = x4 + 1;
        if(isBound(y5, x5, map.length)){
            if(map[y5][x5] == 0){
                Pipe pipe1 = new Pipe(new int[]{y4, y5}, new int[]{x4, x5});
                result += solve(map, pipe1);
            }
        }

        // 수직으로 이동
        y5 = y4 + 1;
        x5 = x4;
        if(isBound(y5, x5, map.length)){
            if(map[y5][x5] == 0){
                Pipe pipe1 = new Pipe(new int[]{y4, y5}, new int[]{x4, x5});
                result += solve(map, pipe1);
            }
        }

        // 대각선으로 이동
        y5 = y4 + 1;
        x5 = x4 + 1;
        if(isBound(y5, x5, map.length)){
            if(map[y5][x5] == 0 && map[y5-1][x5] == 0 && map[y5][x5-1] == 0){
                Pipe pipe1 = new Pipe(new int[]{y4, y5}, new int[]{x4, x5});
                result += solve(map, pipe1);
            }
        }

        return result;
    }
    private static boolean isBound(int y1, int x1, int length) {
        return y1 >= 0 && y1 < length && x1 >= 0 && x1 < length;
    }

}
