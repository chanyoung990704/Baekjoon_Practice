import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            if(Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }else{
                sb.append(c);
            }
        }

        int[] cnt = new int[26];
        for(int i = 0 ; i < sb.length() ; i++){
            char cur = sb.charAt(i);
            cnt[cur - 'A']++;
        }

        int max = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(cnt[i] > max){
                max = cnt[i];
            }
        }

        int c = 0;
        int idx = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(cnt[i] == max){
                c++;
                idx = i;
            }
        }

        if(c > 1){
            System.out.println('?');
        }else{
            char res = (char)('A' + idx);
            System.out.println(res);
        }
    }
}
