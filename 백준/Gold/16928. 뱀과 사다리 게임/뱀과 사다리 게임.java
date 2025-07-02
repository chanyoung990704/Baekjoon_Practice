import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    static class Node{
        int to;
        boolean special = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        Node[][] graph = new Node[10][10];

        for(int i = 0 ; i < 10 ; i++) {
            for(int j = 0; j < 10; j++) {
                graph[i][j] = new Node();
            }
        }


        for(int i = 0; i < N + M; i++) {
            int[] fromTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] idx = numToIdx(fromTo[0]);
            graph[idx[0]][idx[1]].special = true;
            graph[idx[0]][idx[1]].to = fromTo[1];
        }

        boolean[][] visited = new boolean[10][10];
        visited[0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int[] idx = numToIdx(cur[0]);
            int y = idx[0];
            int x = idx[1];
            int cnt = cur[1];

            if(y == 9 && x == 9) {
                System.out.println(cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if(next > 100){
                    break;
                }
                int[] nextIdx = numToIdx(next);
                int ny, nx;
                if(graph[nextIdx[0]][nextIdx[1]].special) {
                    next = graph[nextIdx[0]][nextIdx[1]].to;
                    nextIdx = numToIdx(graph[nextIdx[0]][nextIdx[1]].to);
                }
                ny = nextIdx[0];
                nx = nextIdx[1];
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }

        }

        System.out.println(-1);

    }

    static int[] numToIdx(int num) {
        num--;
        return new int[]{num / 10, num % 10};
    }
}
