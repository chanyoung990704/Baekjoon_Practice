class Solution {
    
    int target;
    
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        int answer = dfs(numbers, 0, 0);
        return answer;
    }
    
    
    
    
    int dfs(int[] numbers, int cur, int result){
        
        if(cur == numbers.length){
            if(result == target)
                return 1;
            else 
                return 0;
        }
        
        int total = 0;
        
        total += dfs(numbers, cur + 1, result + numbers[cur]);
        total += dfs(numbers, cur + 1, result - numbers[cur]);
        
        return total;
    }
    
    
}