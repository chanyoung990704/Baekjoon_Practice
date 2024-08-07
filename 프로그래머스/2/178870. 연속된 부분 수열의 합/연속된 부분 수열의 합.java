class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 10000000};
        
        int len = sequence.length;
        int intervalSum = 0;
        int end = 0;
        
        for(int start = 0 ; start < len ; start++){
            
            while(end < len && intervalSum < k) intervalSum += sequence[end++];
            if(intervalSum == k){
                int cur = answer[1] - answer[0];
                if((end - 1) - start < cur){
                    answer[0] = start;
                    answer[1] = end - 1;
                }
            }
            intervalSum -= sequence[start];
        }
        
        return answer;
    }
}