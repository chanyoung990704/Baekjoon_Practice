import java.util.*;
class Solution {
    public int solution(String arr[]) {
        
        int n = (arr.length + 1) / 2 ;
        
        int[][] dpMAX = new int[n][n]; // i번째 숫자부터 j번쨰 숫자까지
        int[][] dpMIN = new int[n][n];
        
        for(int i = 0 ; i < n;  i++){
            Arrays.fill(dpMAX[i], Integer.MIN_VALUE);
            Arrays.fill(dpMIN[i], Integer.MAX_VALUE);            
        }
        
        for(int i = 0 ; i < n ; i++){
            dpMAX[i][i] = dpMIN[i][i] = Integer.valueOf(arr[i * 2]);
        }
        
        for(int window = 2 ; window <= n ; window++){
            for(int i = 0 ; i < n - window + 1 ; i++){
                int j = window + i - 1;
                for(int k = i ; k < j ; k++){
                    String op = arr[2 * k + 1];
                    if(op.equals("+")){
                        dpMAX[i][j] = Math.max(dpMAX[i][j], dpMAX[i][k] + dpMAX[k + 1][j]);
                        dpMIN[i][j] = Math.min(dpMIN[i][j], dpMIN[i][k] + dpMIN[k + 1][j]);
                    }else{
                        dpMAX[i][j] = Math.max(dpMAX[i][j], dpMAX[i][k] - dpMIN[k + 1][j]);
                        dpMIN[i][j] = Math.min(dpMIN[i][j], dpMIN[i][k] - dpMIN[k + 1][j]);
                    }
                }
                
            }
            
        }
        
        return dpMAX[0][n-1];
    }
}