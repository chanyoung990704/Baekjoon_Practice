import java.util.*;
import java.util.stream.*;

class Solution {
    Map<Integer, Character> map = new HashMap<>();
    Map<Character, Integer> cmap = new HashMap<>();
    
    
    public String solution(long n, String[] bans) {
        
        for(int i = 0 ; i < 26 ; i++){
            map.put(i, (char)('a' + i));
            cmap.put((char)('a' + i), i + 1);
            
        } 
        
        List<Long> bansNum = Arrays.stream(bans)
            .map(i -> getNum(i))
            .sorted()
            .collect(Collectors.toList());
        
        for(long bn : bansNum){
            if(bn <= n){
                n++;
            }
        }

        return getAlphabets(n);
    }
    
    
    // n번쨰 얻기
    String getAlphabets(long n){
        int L = 1;
        long sum = 26;
        
        // 길이 찾기
        while(sum < n){
            n -= sum;
            sum *= 26;
            L++;
        }
        
        // 문자열 만들기
        long target = n-1;
        StringBuilder sb = new StringBuilder();

        
        while(target > 0){
            sb.append(map.get((int)(target % 26)));
            target /= 26;
        }
        
        
        while(sb.length() < L){
            sb.append('a');
        }
        
        return sb.reverse().toString();
    }
    
    long getNum(String str){
        long sum = 0;
        long mul = 1;
        
        for(int i = 1 ; i < str.length(); i++){
            mul *= 26;
        }
        
        for(char c : str.toCharArray()){
            sum += cmap.get(c) * mul;
            mul /= 26;
        }
        
        return sum;
    }
}