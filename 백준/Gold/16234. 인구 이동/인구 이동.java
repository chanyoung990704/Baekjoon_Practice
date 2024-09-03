import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static List<List<Integer>> adj;
    static int N;
    static int L;
    static int R;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NLR = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        
        N = NLR[0];
        L = NLR[1];
        R = NLR[2];

        adj = new ArrayList<>();
        for(int i = 0 ; i < NLR[0] ; i++) adj.add(Arrays.stream(br.readLine().split(" "))
                                                        .map(Integer::valueOf)
                                                        .collect(Collectors.toList()));
        
        int cnt = 0;
        while(true) {
            boolean isOccured = false;
            boolean[][] visited = new boolean[NLR[0]][NLR[0]];
            for(int i = 0 ; i < NLR[0] ; i++)
                for(int j = 0 ; j < NLR[0] ; j++)
                    if(!visited[i][j])
                        if(bfs(new Point(i, j), visited)) isOccured = true;

            if(!isOccured) break;
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

    static boolean bfs(Point cur, boolean[][] visited) {
        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1, -1, 0,0};

        Deque<Point> dq = new ArrayDeque<>();
        List<Point> list  = new ArrayList<>();

        dq.offer(cur);
        visited[cur.y][cur.x] = true;

        while (!dq.isEmpty()) {

            Point p = dq.pollFirst();
            list.add(p);

            for(int i = 0 ; i < 4 ; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N)
                    if(!visited[ny][nx]){
                        int diff = Math.abs(adj.get(p.y).get(p.x) - adj.get(ny).get(nx));
                        if(diff >= L && diff <= R){
                            visited[ny][nx] = true;
                            dq.offer(new Point(ny, nx));
                        }
                    }
            }

        }

        if(list.size() == 1) return false;

        int total = list.stream()
                        .mapToInt(p -> adj.get(p.y).get(p.x))
                        .sum();
        int remain = total / list.size();

        for(int i = 0 ; i < list.size() ; i++) adj.get(list.get(i).y).set(list.get(i).x, remain);

        return true;
    }

    static class Point{
        int y;
        int x;

        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}