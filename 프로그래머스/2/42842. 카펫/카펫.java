class Solution {
    
    int weight = -1;
    int height = -1;
    
    
    public int[] solution(int brown, int yellow) {
        
        int wPh = (brown + 4) / 2; // 가로 + 세로
        
        for(int h = 1 ; h <= wPh / 2 ; h++) {
            int w = wPh - h;
            if(h * w - brown == yellow){
                weight = w;
                height = h;
                break;
            }
        }
        
        return new int[]{weight, height};
    }
}