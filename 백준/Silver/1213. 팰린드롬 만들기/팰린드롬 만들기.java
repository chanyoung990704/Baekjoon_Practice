import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] cnt = new int[26];
        for(int i = 0 ; i < s.length() ; i++) cnt[s.charAt(i) - 'A']++;

        int oddCnt = 0;
        char oddChar = 'a';

        for(int i = 0 ; i < cnt.length ; i++){
            if(cnt[i] % 2 == 1){
                oddCnt++;
                oddChar = (char)('A' + i);
            }
        }

        if(oddCnt > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < cnt.length ; i++){
            if(cnt[i] > 0){
                for(int j = 0 ; j < cnt[i] / 2 ; j++){
                    sb.append((char)('A' + i));
                }
            }
        }

        String ret = "";

        ret += sb.toString();
        if(oddCnt == 1) ret += oddChar;
        ret += sb.reverse().toString();

        System.out.println(ret);

        br.close();

    }
}
