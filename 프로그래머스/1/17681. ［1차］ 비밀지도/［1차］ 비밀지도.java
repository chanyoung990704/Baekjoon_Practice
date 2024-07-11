import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        return IntStream.range(0, n)
            .mapToObj(i -> {
                String s = Integer.toBinaryString(arr1[i] | arr2[i]);
                while(s.length() < n){
                    s = "0" + s;
                }
                return s;
            })
            .map(s -> {
                StringBuilder sb = new StringBuilder();
                for(char c : s.toCharArray()){
                    if(c - '0' == 1)
                        sb.append("#");
                    else
                        sb.append(" ");
                }
                return sb.toString();
            })
            .toArray(String[]::new);
    }
}