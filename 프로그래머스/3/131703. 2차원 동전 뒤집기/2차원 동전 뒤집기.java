import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] target;
    int col_len;
    int row_len;
    int ret = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        this.target = target;
        row_len = target.length;
        col_len = target[0].length;
        
        
        swapRow(beginning, 0, 0);
        if(ret == Integer.MAX_VALUE) return -1;
        return ret;
    }
    
    void swapColumn(int[][] arr, int cnt){
        for(int i = 0 ; i < col_len ; i++){
            if(arr[0][i] != target[0][i]){
                cnt++;
                for(int j = 0 ; j < row_len ; j++){
                    if(arr[j][i] == 0) arr[j][i] = 1;
                    else arr[j][i] = 0;
                }
            }
        }
        if(isSame(arr)) ret = Math.min(ret, cnt);
    }
    
    
    void swapRow(int[][] arr, int idx, int cnt){
        // basecase
        if(idx == row_len){
            // ColumnSwap
            swapColumn(arr, cnt);
            return;
        }
        
        // 안바뀌는 경우
        swapRow(copiedArr(arr), idx + 1, cnt);
        
        // 스왑하는 경우
        int[][] copied = copiedArr(arr);
        for(int i = 0 ; i < col_len ; i++){
            if(copied[idx][i] == 1) copied[idx][i] = 0;
            else copied[idx][i] = 1;
        }
        swapRow(copied, idx + 1, cnt + 1);
    }
    
    int[][] copiedArr(int[][] arr){
        int[][] copied = new int[row_len][col_len];
        for(int i = 0 ; i < row_len ; i++)
            for(int j = 0 ; j < col_len ; j++)
                copied[i][j] = arr[i][j];
        return copied;
    }
    
    boolean isSame(int[][] arr){
        for(int i = 0 ; i < row_len ; i++)
            for(int j = 0 ; j < col_len ; j++)
                if(arr[i][j] != target[i][j]) return false;
        return true;
    }
}