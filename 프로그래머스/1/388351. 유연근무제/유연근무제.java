class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0 ; i < schedules.length ; i++){
            int s = schedules[i];
            int e = getEndTime(s);
            
            boolean complete = true;
            for(int j = 0 ; j < 7 ; j++){
                int cur = (j + startday - 1) % 7 + 1; // 1~7 반복
                
                // 토요일(6), 일요일(7)은 출근 체크 제외
                if(cur == 6 || cur == 7) continue;
                
                if(timelogs[i][j] > e){
                    complete = false;
                    break;
                }
            }
            
            if(complete){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int getEndTime(int startTime){
        int h = startTime / 100;
        int m = startTime % 100 + 10;

        if(m >= 60){
            h += m / 60;
            m %= 60;
        }

        return h * 100 + m;
    }
}
