import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] board;
    int r, c;
    int res = Integer.MAX_VALUE;
    
    public int solution(int[][] board, int r, int c) {
        // 전역 변수 초기화
        this.board = board;
        this.r = r;
        this.c = c;
        
        // 카드 종류 파악
        Set<Integer> cards = Arrays.stream(board)
            .flatMapToInt(b -> Arrays.stream(b)).boxed()
            .filter(b -> b != 0)
            .collect(Collectors.toSet());
                
        int len = cards.size();
        
        // 순열 생성
        permutation(cards, len, new ArrayDeque<>());
        
        int answer = 0;
        return res;
    }
    
    void permutation(Set<Integer> s, int l, Deque<Integer> r){
        // basecase
        if(r.size() == l){
            solve(r);
            return;
        }
    
        for(int i : s){
            if(!r.contains(i)){
                r.offerLast(i);
                permutation(s, l , r);
                r.pollLast();
            }
        }
    }
    
    void solve(Deque<Integer> r){
        // 원본 복사
        int[][] copied = new int[board.length][];
        for(int i = 0 ; i < copied.length ; i++){
            copied[i] = Arrays.copyOf(board[i], board[i].length);
        }
        int cr = this.r;
        int cc = this.c;
        int cost = 0;
        
        // 카드 종류 선택
        for(int card : r){            
            // 카드 두장 위치 찾기
            int[] idxs = findCard(card, copied); // y, x, y1, x1
            
            int cost1 = bfs(idxs[0], idxs[1], cr, cc, copied);
            cost1 += bfs(idxs[2], idxs[3], idxs[0], idxs[1], copied);
            
            int cost2 = bfs(idxs[2], idxs[3], cr, cc, copied);
            cost2 += bfs(idxs[0], idxs[1], idxs[2], idxs[3], copied);            
            
            
            if(cost1 < cost2){
                cost += cost1;
                cr = idxs[2];
                cc = idxs[3];
            }else{
                cost += cost2;
                cr = idxs[0];
                cc = idxs[1];
            }
            cost += 2;
            copied[idxs[0]][idxs[1]] = 0;
            copied[idxs[2]][idxs[3]] = 0;
            
        }
        
        res = Math.min(res, cost);
    }
    
    int bfs(int tr, int tc, int cr, int cc, int[][] copied){
        if(tr == cr && tc == cc){
            return 0;
        }
        
        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1,-1,0,0};
        
        boolean[][] visited = new boolean[copied.length][copied[0].length];
        Deque<List<Integer>> dq = new ArrayDeque<>();
        dq.offer(List.of(cr, cc, 0));
        visited[cr][cc] = true;
        
        while(!dq.isEmpty()){
            List<Integer> cur = dq.pollFirst();
            int y = cur.get(0);
            int x = cur.get(1);
            int cost = cur.get(2);
            
            // 목표
            if(y == tr && x == tc){
                return cost;
            }
            
            // 한칸 이동
            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && ny < copied.length && nx >= 0 && nx < copied[0].length
                  && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    dq.offer(List.of(ny,nx,cost+1));
                }
                
            }
            
            // 컨트롤 이동
            for(int i = 0 ; i < 4 ; i++){
                int[] nextPos = ctrlMove(y, x, dy[i], dx[i], copied);
                int ny = nextPos[0];
                int nx = nextPos[1];
                
                if(!(ny == y && nx == x) && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    dq.offer(List.of(ny,nx,cost+1));
                }
            }
            
        }
        
        return -1;
    }
    
    int[] ctrlMove(int y, int x, int dy, int dx, int[][] copied){
        int ny = y;
        int nx = x;
        
        while(true){
            int ty = ny + dy;
            int tx = nx + dx;
            
            if(ty < 0 || ty >= copied.length || tx < 0 || tx >= copied[0].length){
                return new int[]{ny, nx};
            }
            
            ny = ty;
            nx = tx;
            
            // 카드면 ㄹ턴
            if(copied[ny][nx] != 0){
                return new int[]{ny, nx};
            }
            
        }
    }

    int[] findCard(int card, int[][] copied){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < copied.length ; i++){
            for(int j = 0 ; j < copied[i].length ; j++){
                if(copied[i][j] == card){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}