import java.util.*;
import java.util.stream.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(1,2,3,n);
        return list.stream()
            .toArray(int[][]::new);
    }
    
    void hanoi(int start, int mid, int from, int n){
        if(n == 1){
            System.out.println("" + start + " -> " + from);
            list.add(new int[]{start, from});
            return;
        }
        
        // n - 1개 중간에 옮기기
        hanoi(start, from, mid, n - 1);
        System.out.println("" + start + " -> " + from);
        list.add(new int[]{start, from});
        hanoi(mid, start, from, n - 1);
    }
}