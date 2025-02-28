import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n + 2];
        Arrays.fill(students, 1);
        
        for(int l : lost){
            students[l]--;
        }
        for(int r : reserve){
            students[r]++;
        }
        
        // 1번학생부터 확인
        for(int i = 1; i <= n ; i++){
            if(students[i] == 0){
                if(students[i - 1] == 2){
                    students[i - 1]--;
                    students[i]++;
                }
                else if(students[i + 1] == 2){
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        
        return (int)IntStream.range(1, n + 1)
            .filter(i -> students[i] >= 1).count();
    }
}