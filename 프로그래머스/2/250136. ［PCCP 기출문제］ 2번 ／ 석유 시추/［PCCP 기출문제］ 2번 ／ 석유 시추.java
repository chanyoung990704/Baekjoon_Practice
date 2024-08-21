import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        int[][] landInfo = new int[land.length][land[0].length];
        Map<Integer, Integer> infoSize = new HashMap<>();
        int blockCnt = 1;
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int i = 0 ; i < land.length ; i++)
            for(int j = 0 ; j < land[0].length ; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    // BFS
                    Deque<List<Integer>> dq = new ArrayDeque<>();
                    visited[i][j] = true;
                    dq.offer(List.of(i, j));
                    int cnt = 0;
                    
                    while(!dq.isEmpty()) {
                        List<Integer> cur = dq.pollFirst();
                        landInfo[cur.get(0)][cur.get(1)] = blockCnt;
                        cnt++;
                        int[] dx = new int[]{0,0,1,-1};
                        int[] dy = new int[]{1,-1,0,0};
                        for(int k = 0 ; k < 4 ; k++){
                            int ny = cur.get(0) + dy[k];
                            int nx = cur.get(1) + dx[k];
                            if(ny >= 0 && ny < land.length && nx >= 0 && nx < land[0].length)
                                if(!visited[ny][nx] && land[ny][nx] == 1) {
                                    visited[ny][nx] = true;
                                    dq.offer(List.of(ny, nx));
                                }
                            
                        }
                    }
                    // Map에 사이즈 저장
                    infoSize.put(blockCnt, cnt);
                    blockCnt++;
                    
                }
            }
        
        int max = 0;
        
        // 열 순회
        for(int col = 0 ; col < land[0].length ; col++){
            Set<Integer> set = new HashSet<>();
            for(int row = 0 ; row < land.length ; row++){
                if(landInfo[row][col] > 0)
                    set.add(landInfo[row][col]);
            }
            int curResult = 0;
            for(int num : set) curResult += infoSize.get(num);
            max = Math.max(max, curResult);
        }
        
        
        return max;
    }
}