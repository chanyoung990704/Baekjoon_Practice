import java.util.*;

class Solution {
    
    boolean[] visited;
    List<Integer> list;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        list = new ArrayList<>();
        bruteForce(numbers, "");
        
        int max = list.stream().mapToInt(Integer::valueOf).max().orElse(0);
        if(max < 2){
            return 0;
        }
        
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2 ; i <= Math.sqrt(max) ; i++)
            if(isPrime[i])
                for(int j = i * i ; j <= max ; j += i)
                    isPrime[j] = false;
        
        return (int)list.stream()
            .distinct()
            .filter(i -> isPrime[i])
            .count();
        
    }
    
    void bruteForce(String numbers, String result) {
        if(result.length() > 0){
            list.add(Integer.valueOf(result));
        }
        
        for(int i = 0 ; i < numbers.length() ; i++){
            if(!visited[i]){
                visited[i] = true;
                bruteForce(numbers, result + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
}