import java.util.*;
import java.util.stream.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr){
            if(!stack.empty() && stack.peek() == a)
                continue;
            else
                stack.push(a);
        }
    
        return stack.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}