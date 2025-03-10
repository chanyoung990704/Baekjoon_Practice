import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] nums = Arrays.stream(numbers.split(""))
            .mapToInt(Integer::valueOf).toArray();
        
        Set<Integer> set = new HashSet<>();
        solve(nums, "", new boolean[nums.length], set);
        
        // 소수 판정
        for(int n : set){
            if(n < 2){
                continue;
            }
            
            boolean isPrime = true;
            for(int i = 2 ; i < n ; i++){
                if(n % i == 0){
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime){
                answer++;
            }
        }
        
        return answer;
    }
    
    
    void solve(int[] nums, String res, boolean[] visited, Set<Integer> set){
        
        if(res.length() > 0){
            set.add(Integer.valueOf(res));
        }
        
        // 처음 숫자는 0이면 안됨
        for(int i = 0 ; i < nums.length ; i++){
            int n = nums[i];
            if(res.length() == 0 && n == 0){
                continue;
            }
            
            // 백트래킹
            if(!visited[i]){
                StringBuilder sb = new StringBuilder(res);
                int len = res.length();
                sb.append(n);
                visited[i] = true;
                solve(nums, sb.toString(), visited, set);
                visited[i] = false;
                sb.setLength(len);
            }
            
        }
        
    }
}