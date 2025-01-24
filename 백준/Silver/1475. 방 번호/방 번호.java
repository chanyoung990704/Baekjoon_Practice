import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();

        int cnt = 0; // 6이나 9일때
        Map<Integer, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            if(c == '6' || c == '9'){
                cnt++;
            }
            else{
                int k = c - '0';
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }

        cnt = cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
        // 가장 큰 값 찾기
        if(!map.values().isEmpty()){
            cnt = Math.max(Collections.max(map.values()), cnt); 
        }
    
        System.out.println(cnt);
    }
}
