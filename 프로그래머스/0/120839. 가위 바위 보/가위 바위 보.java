class Solution {
    public String solution(String rsp) {
        
        String[] str_arr = rsp.split("");
        StringBuffer sb = new StringBuffer("");
        
        for(var i = 0 ; i < str_arr.length ; i++){
            if(str_arr[i].equals("2"))
                sb.append("0");
            else if(str_arr[i].equals("0"))
                sb.append("5");
            else
                sb.append("2");
                
        }
        
        return sb.toString();
    }
}