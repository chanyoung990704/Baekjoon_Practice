import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int l = findIdx("l", str_list);
        int r = findIdx("r", str_list);
        
        if(l == Integer.MAX_VALUE && r == Integer.MAX_VALUE) return new String[]{};
        
        List<String> res = new ArrayList<>();
        if(l < r){
            for(int i = 0 ; i < l ; i++) res.add(str_list[i]);
        }else{
            for(int i = r + 1 ; i < str_list.length ; i++) res.add(str_list[i]);
        }
        
        
        return res.stream().toArray(String[]::new);
    }
    
    int findIdx(String s, String[] arr){
        for(int i = 0 ; i < arr.length ; i++)
            if(s.equals(arr[i])) return i;
        return Integer.MAX_VALUE;
    }
}