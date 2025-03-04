import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {

            String W = br.readLine();
            Map<Character, List<Integer>> map = new HashMap<>();
            for(int i = 0 ; i < W.length() ; i++){
                char c = W.charAt(i);
                map.computeIfAbsent(c, (k) -> new ArrayList<>()).add(i);
            }
    
            int K = Integer.valueOf(br.readLine());
    
            int[] cnt = new int[26];
    
            int lo = 0;
            int hi = 0;
            int min = Integer.MAX_VALUE;
    
            while (hi < W.length()) {
                char cur = W.charAt(hi);
                cnt[cur - 'a']++;
    
                while (Arrays.stream(cnt).anyMatch(i -> i == K)) {
                    min = Math.min(min, hi - lo + 1);
                    char prev = W.charAt(lo);
                    cnt[prev - 'a']--;
                    lo++;
                }
                hi++;
            }
    
            // 큰 수
            int max = Integer.MIN_VALUE;
            for(Map.Entry<Character, List<Integer>> e : map.entrySet()){
                List<Integer> v = e.getValue();
                if(v.size() < K){
                    continue;
                }

                int i = 0;

                while (i + K <= v.size()) {
                    int s = v.get(i);
                    int end = v.get(i + K - 1);
                    max = Math.max(max, end - s + 1);
                    i++;
                }
    
            }
    
    
    
            if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min + " " + max);
            }
            
        }
    }
}



