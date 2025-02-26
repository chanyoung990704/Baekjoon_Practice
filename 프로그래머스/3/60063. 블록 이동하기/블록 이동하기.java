import java.util.stream.*;
import java.util.*;

class Solution {


class Robot {
    int x1;
    int y1;
    int x2;
    int y2;
    
    Robot(int x1, int y1, int x2, int y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }
    
    String getStr() {
        return x1 + " " + y1 + " " + x2 + " " + y2;
    }
}

int N;
int[][] board;

public int solution(int[][] board) {
    this.board = board;
    this.N = board.length;
    
    Set<String> visited = new HashSet<>();
    Robot initial = new Robot(0, 0, 1, 0);
    visited.add(initial.getStr());
    
    // BFS
    Deque<List<Integer>> dq = new ArrayDeque<>();
    dq.offer(List.of(0, 0, 0, 1, 0));
    
    while (!dq.isEmpty()) {
        List<Integer> cur = dq.pollFirst();
        int y1 = cur.get(0);
        int x1 = cur.get(1);
        int y2 = cur.get(2);
        int x2 = cur.get(3);
        int cnt = cur.get(4);
        
        // baseCase
        if ((y1 == N-1 && x1 == N-1) || (y2 == N-1 && x2 == N-1)) {
            return cnt;
        }
        
        // 상하좌우 이동
        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};
        
        for (int i = 0; i < 4; i++) {
            int ny1 = y1 + dy[i];
            int nx1 = x1 + dx[i];
            int ny2 = y2 + dy[i];
            int nx2 = x2 + dx[i];
            
            if (isBoundary(ny1, nx1) && isBoundary(ny2, nx2)) {
                String nextVisit = new Robot(nx1, ny1, nx2, ny2).getStr();
                if (!visited.contains(nextVisit) && isMove(ny1, nx1, ny2, nx2)) {
                    visited.add(nextVisit);
                    dq.offer(List.of(ny1, nx1, ny2, nx2, cnt + 1));
                }
            }
        }
        
        // 회전
        
        // 로봇이 가로로 놓여있을 때
        if (y1 == y2) {
            // 위 확인
            if (isBoundary(y1 - 1, x1) && isBoundary(y2 - 1, x2) && isMove(y1 - 1, x1, y2 - 1, x2)) {
                // 회전 삽입
                String nextVisit1 = new Robot(x1, y1 - 1, x1, y1).getStr();
                String nextVisit2 = new Robot(x2, y2 - 1, x2, y2).getStr();
                
                if (!visited.contains(nextVisit1)) {
                    visited.add(nextVisit1);
                    dq.offer(List.of(y1 - 1, x1, y1, x1, cnt + 1));
                }
                if (!visited.contains(nextVisit2)) {
                    visited.add(nextVisit2);
                    dq.offer(List.of(y2 - 1, x2, y2, x2, cnt + 1));
                }                    
            }
            
            // 아래 확인
            if (isBoundary(y1 + 1, x1) && isBoundary(y2 + 1, x2) && isMove(y1 + 1, x1, y2 + 1, x2)) {
                // 회전 삽입
                String nextVisit1 = new Robot(x1, y1, x1, y1 + 1).getStr();
                String nextVisit2 = new Robot(x2, y2, x2, y2 + 1).getStr();
                
                if (!visited.contains(nextVisit1)) {
                    visited.add(nextVisit1);
                    dq.offer(List.of(y1, x1, y1 + 1, x1, cnt + 1));
                }
                if (!visited.contains(nextVisit2)) {
                    visited.add(nextVisit2);
                    dq.offer(List.of(y2, x2, y2 + 1, x2, cnt + 1));
                }                    
            }                
        }
        
        // 로봇이 세로
        if (x1 == x2) {
            // 오른쪽 확인
            if (isBoundary(y1, x1 + 1) && isBoundary(y2, x2 + 1) && isMove(y1, x1 + 1, y2, x2 + 1)) {
                // 회전 삽입
                String nextVisit1 = new Robot(x1, y1, x1 + 1, y1).getStr();
                String nextVisit2 = new Robot(x2, y2, x2 + 1, y2).getStr();
                
                if (!visited.contains(nextVisit1)) {
                    visited.add(nextVisit1);
                    dq.offer(List.of(y1, x1, y1, x1 + 1, cnt + 1));
                }
                if (!visited.contains(nextVisit2)) {
                    visited.add(nextVisit2);
                    dq.offer(List.of(y2, x2, y2, x2 + 1, cnt + 1));
                }                    
            }
            
            // 왼쪽 확인
            if (isBoundary(y1, x1 - 1) && isBoundary(y2, x2 - 1) && isMove(y1, x1 - 1, y2, x2 - 1)) {
                // 회전 삽입
                String nextVisit1 = new Robot(x1 - 1, y1, x1, y1).getStr();
                String nextVisit2 = new Robot(x2 - 1, y2, x2, y2).getStr();
                
                if (!visited.contains(nextVisit1)) {
                    visited.add(nextVisit1);
                    dq.offer(List.of(y1, x1 - 1, y1, x1, cnt + 1));
                }
                if (!visited.contains(nextVisit2)) {
                    visited.add(nextVisit2);
                    dq.offer(List.of(y2, x2 - 1, y2, x2, cnt + 1));
                }                    
            }                
        }
    }
    
    return -1; // 목적지에 도달할 수 없는 경우
}

boolean isMove(int y1, int x1, int y2, int x2) {
    return board[y1][x1] == 0 && board[y2][x2] == 0;
}

boolean isBoundary(int y, int x) {
    return y >= 0 && y < N && x >= 0 && x < N;
}
}