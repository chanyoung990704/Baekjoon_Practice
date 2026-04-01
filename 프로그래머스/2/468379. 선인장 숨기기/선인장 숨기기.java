import java.util.*;

class Solution {
    int m,n,h,w;
    int[][] drops;
    int[] answer = {};
    
    // 맵 만들기
    int[][] arr;
    
    int[] idx = new int[2];
    int max = -1;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        this.m = m; this.n=n; this.h=h; this.w=w; this.drops=drops;
        
        arr = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        
        // drops 
        int order = 1;
        for(int[] drop : drops){
            int r = drop[0], c = drop[1];
            arr[r][c] = order++;
        }
        
        // 슬라이딩 윈도우 (가로)
        int[][] minRow = new int[m][n-w+1];
        for(int r = 0 ; r < m ; r++){
            Deque<Integer> dq = new ArrayDeque<>();
            for(int c = 0 ; c < n ; c++){
                // 범위 이탈
                if(!dq.isEmpty() && dq.peekFirst() <= c-w){
                    dq.pollFirst();
                }
                
                // 최솟값 구하기
                while(!dq.isEmpty() && arr[r][dq.peekLast()] > arr[r][c]){
                    dq.pollLast();
                }
                
                dq.offerLast(c);
                
                // 현재 윈도우 저장
                if(c >= w-1){
                    minRow[r][c-w+1] = arr[r][dq.peekFirst()];
                }
            }
        }
        
        // 슬라이딩 윈도우 세로
        for(int c = 0 ; c < n-w+1 ; c++){
            Deque<Integer> dq = new ArrayDeque<>();
            for(int r = 0 ; r < m ; r++){
                // 세로 윈도우
                if(!dq.isEmpty() && dq.peekFirst() <= r-h){
                    dq.pollFirst();
                }
                // 최솟값 찾기
                while(!dq.isEmpty() && minRow[dq.peekLast()][c] > minRow[r][c]){
                    dq.pollLast();
                }
                
                dq.offer(r);
                
                // 갱신
                if(r >= h-1){
                    int curVal = minRow[dq.peekFirst()][c];
                    int startR = r-h+1;
                    
                    // 갱신해야 하면
                     if(max < curVal){
                         max = curVal;
                         idx[0] = startR;
                         idx[1] = c;
                     }
                    // 가장 왼쪽 위칸 좌표라면
                    else if(max == curVal && ((startR < idx[0]) || (startR == idx[0] && idx[1] > c))){
                        idx[0] = startR;
                        idx[1] = c;
                    }
                }
            }
        }
        
        return idx;
    }
}