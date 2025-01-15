import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        // 역방향 탐색
        while (s.length() < t.length()) {
            // 마지막 단어
            char lastCur = t.charAt(t.length() - 1);
            // 삭제
            t.deleteCharAt(t.length() - 1);

            // 마지막 단어가 B이면 뒤집기
            if(lastCur == 'B'){
                t.reverse();
            }
        }


        if(t.toString().equals(s.toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
