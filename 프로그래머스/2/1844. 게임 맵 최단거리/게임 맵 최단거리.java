import java.util.*;

class Solution {
    class Point {
        int x, y, cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    int h, w;
    
    public int solution(int[][] maps) {
        h = maps.length;
        w = maps[0].length;
        
        boolean[][] visited = new boolean[h][w];
        Deque<Point> deque = new ArrayDeque<>();
        deque.offerLast(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while (!deque.isEmpty()) {
            Point cur = deque.pollFirst();
            
            if (cur.y == h - 1 && cur.x == w - 1) {
                return cur.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (isPossible(ny, nx) && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    deque.offerLast(new Point(nx, ny, cur.cnt + 1));
                }
            }
        }
        
        return -1;
    }
    
    boolean isPossible(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}