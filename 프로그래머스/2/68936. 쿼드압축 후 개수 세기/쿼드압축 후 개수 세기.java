import java.util.*;
import java.util.stream.*;

class Solution {
    
    int[] answer = new int[2];
        
    public int[] solution(int[][] arr) {
        
        compressArr(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    
    public void compressArr(int[][] arr, int y, int x, int n){
        // 1칸이면 리턴
        if(n == 1){
            answer[arr[y][x]]++;
            return;
        }
                
        // 합 확인
        long sum = IntStream.range(0, n)
            .map(i -> IntStream.range(0, n)
                .map(j -> arr[y + i][x + j])
                .sum()
                )
            .sum();
        
        // 압축
        if(sum == 0){
            answer[0]++;
            return;
        }else if(sum == n * n){
            answer[1]++;
            return;
        }
        
        compressArr(arr, y, x, n / 2);
        compressArr(arr, y, x + n / 2, n / 2);
        compressArr(arr, y + n / 2, x, n / 2);
        compressArr(arr, y + n / 2, x + n / 2, n / 2);
        
        return;
    }
}