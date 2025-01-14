import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);

        for(int i = 0 ; i < input.length() ; i++){
            char cur = input.charAt(i);
            if(cnt[cur - 'a'] == -1){
                cnt[cur - 'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : cnt){
            sb.append(n + " ");
        }

        System.out.println(sb.toString());

    }
}
