class Solution {
    public long solution(int[] sequence) {
        
        // 처음 1인 시퀀스
        int[] sequence1 = new int[sequence.length];
        
        // 처음 -1인 시퀀스
        int[] sequence2 = new int[sequence.length];
        
        for(int i = 0 ; i < sequence.length ; i++){
            if(i % 2 == 0){
                sequence1[i] = sequence[i];
                sequence2[i] = sequence[i] * -1;
            }
            else{
                sequence1[i] = sequence[i] * -1;
                sequence2[i] = sequence[i];
            }
        }
        
        // 카데인 알고리즘
        long answer = 0;
        long sub = 0;
        
        // 1번 시퀀스
        for(int i = 0 ; i < sequence.length ; i++){
            sub = Math.max(sub + sequence1[i], sequence1[i]);
            answer = Math.max(answer, sub);
        }
        
        sub = 0;
        // 2번 시퀀스
        for(int i = 0 ; i < sequence.length ; i++){
            sub = Math.max(sub + sequence2[i], sequence2[i]);
            answer = Math.max(answer, sub);
        }
        return answer;
    }
}