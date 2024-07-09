class Solution {
    public int solution(String my_string) {
        
        String[] arr = my_string.split(" ");
        var len = arr.length;
        
        var answer = Integer.valueOf(arr[0]);
        
        for(int i = 1 ; i < len ; i += 2){
            
            if(arr[i].equals("+")){
                answer += Integer.valueOf(arr[i + 1]);
            }else{
                answer -= Integer.valueOf(arr[i + 1]);
            }
            
        } 
        
        return answer;
    }
}