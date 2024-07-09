class Solution {
    public int solution(int[][] dots) {
        int weight = dots[0][0];
        int height = dots[0][1];
        
        // 가로 구하기
        for(int[] d : dots){
            if(weight != d[0]){
                weight = (int)Math.abs(weight - d[0]);
                break;
            }
        }
        
        // 세로
        for(int[] d : dots){
            if(height != d[1]){
                height = (int)Math.abs(height - d[1]);
                break;
            }
        }        
        
        return weight * height;
    }
}