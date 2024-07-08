class Solution {
    public int[] solution(int[] array) {
        
        int idx = 0;
        int maxValue = array[0];
        
        for(var i = 0 ; i < array.length ; i++)
            if(maxValue < array[i]){
                idx = i;
                maxValue = array[i];
            }
        
        return new int[]{maxValue, idx};
    }
}