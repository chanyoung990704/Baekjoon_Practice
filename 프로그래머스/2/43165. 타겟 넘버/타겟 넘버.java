class Solution {
    
    int[] numbers;
    int target;
    int answer = 0;
    int len;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        len = numbers.length;
        
        dfs(0, 0);
        return answer;
    }
    
    void dfs(int idx, int sum){
        if(idx == len){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]);
    }
}