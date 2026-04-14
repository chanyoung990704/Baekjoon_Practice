class Solution {
    public int[] solution(int e, int[] starts) {
        
        int[] cnt = new int[e+1];
        
        for(int i = 1 ; i <= e ; i++){
            for(int j = i ; j <= e ; j += i){
                cnt[j]++;
            }
        }
        
        int[] bests = new int[e+1];
        int max = 0;
        int num = 0;
        
        for(int i = e ; i >= 1 ; i--){
            if(max <= cnt[i]){
                max = cnt[i];
                num = i;
            }
            bests[i] = num;
        }
        
        int[] answer = new int[starts.length];
        for(int i = 0 ; i < starts.length ; i++){
            answer[i] = bests[starts[i]];
        }
        
        return answer;
    }
}