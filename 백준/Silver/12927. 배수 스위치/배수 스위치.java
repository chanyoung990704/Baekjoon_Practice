import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int cnt = 0;

        // 더미 데이터 삽입
        StringBuilder sb = new StringBuilder();
        sb.append("d" + input);
        for(int i = 1 ; i < sb.length() ; i++){
            char cur = sb.charAt(i);
            if(cur == 'Y'){
                cnt++;
                // 스위치의 배수 전부 반전
                for(int j = 1 ; j <= 1000 ; j++){
                    int nextIdx = i * j;
                    if(nextIdx >= sb.length()) break;
                    char next = sb.charAt(nextIdx);
                    if(next == 'Y') sb.setCharAt(nextIdx, 'N');
                    else if(next == 'N') sb.setCharAt(nextIdx, 'Y');
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
