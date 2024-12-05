class Solution {
    public int solution(int[] num_list) {
        
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for(int n : num_list){
            System.out.println(n);
            if(n % 2 == 0) even.append(String.valueOf(n));
            else odd.append(String.valueOf(n));
        }
        
        return Integer.valueOf(odd.toString()) + Integer.valueOf(even.toString());
    }
}