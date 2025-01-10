import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Snake{
        int y;
        int x;
        Snake(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static int[] dy = new int[]{0,1,0,-1};
    static int[] dx = new int[]{1,0,-1,0};

    static int dir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int K = Integer.valueOf(br.readLine());

        List<List<Integer>> gameMap = new ArrayList<>();
        for(int i = 0 ; i< N ; i++) gameMap.add(new ArrayList<>(Collections.nCopies(N, 0)));

        for(int i = 0 ; i < K ; i++){
            String[] yx = br.readLine().split(" ");
            int y = Integer.valueOf(yx[0]);
            int x = Integer.valueOf(yx[1]);
            gameMap.get(y - 1).set(x - 1, 1);
        }

        int L = Integer.valueOf(br.readLine());
        Map<Integer, String> timeMap = new HashMap<>();
        for(int i = 0 ; i < L ; i++){
            String[] timeDir = br.readLine().split(" ");
            int t = Integer.valueOf(timeDir[0]);
            timeMap.put(t, timeDir[1]);
        }

        // 게임 시작
        int gameTime = 0;
        dir = 0;
        Deque<Snake> snakes = new ArrayDeque<>();
        snakes.offer(new Snake(0, 0));

        while (true) {
            // 이동
            Snake cur = snakes.peekLast();
            int ny = cur.y + dy[dir];
            int nx = cur.x + dx[dir];

            // 이동할 게 범위 밖이면
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) {
                gameTime++;
                break;
            }else if(snakes.stream().anyMatch(s -> s.y == ny && s.x == nx)){ // 몸통 부딪히면
                gameTime++;
                break;
            }

            if(gameMap.get(ny).get(nx) != 1){
                snakes.pollFirst();
            }else{
                gameMap.get(ny).set(nx, 0);
            }
            snakes.offerLast(new Snake(ny, nx));

            // 시간 증가 및 방향 전환
            gameTime++;
            if(timeMap.containsKey(gameTime)){
                changeDir(timeMap.get(gameTime));
            }
        }

        System.out.println(gameTime);
    }

    static void changeDir(String d){
        if(d.equals("D")) dir++;
        if(d.equals("L")) dir--;

        if(dir == 4) dir = 0;
        if(dir == -1) dir  = 3;
    }
    
}
