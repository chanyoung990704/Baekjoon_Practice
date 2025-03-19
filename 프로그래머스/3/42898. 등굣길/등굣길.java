import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        // dp
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }
        
        // 맵
        int[][] arr = new int[n][m];
        // 웅덩이 -1
        for(int[] idx : puddles){
            arr[idx[1] - 1][idx[0] - 1] = -1;
        }
        
        // 시작 지점부터 탐색
        return minDist(arr, dp, 0, 0) ;
    }
    
    int minDist(int[][] arr, int[][] dp, int y, int x){
        // 도착했으면
        if(y == arr.length - 1 && x == arr[0].length - 1){
            return 1;
        }

        // dp에 저장된 값이 있으면 반환
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        // 방향 오른쪽, 아래
        int[] dy = new int[]{0, 1};
        int[] dx = new int[]{1, 0};

        // 경로 개수 초기화
        dp[y][x] = 0;

        for(int i = 0; i < 2; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length){
                if(arr[ny][nx] != -1){
                    dp[y][x] = (dp[y][x] + minDist(arr, dp, ny, nx)) % 1000000007;
                }
            }
        }

        return dp[y][x];
    }
}