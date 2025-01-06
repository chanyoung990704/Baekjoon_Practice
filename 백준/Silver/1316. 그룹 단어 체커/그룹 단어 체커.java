import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            Set<Character> set = new HashSet<>();
            String str = br.readLine();

            for(char c : str.toCharArray()) set.add(c);

            for(char c : set){
                str = str.replaceAll(c + "+", c + "");
            }

            Set<Character> result = new HashSet<>();
            boolean isTrue = true;
            for(char c : str.toCharArray()){
                if(result.contains(c)){
                    isTrue = false;
                    break;
                }
                result.add(c);
            }

            if(isTrue) cnt++;
        }

        System.out.println(cnt);
    }
}
