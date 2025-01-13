import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 최대값 찾기
        StringBuilder max = new StringBuilder();
        int cnt = 0;
        for(int i = 0 ; i < input.length() ; i++){
            char cur = input.charAt(i);
            // k를 찾고 이전까지 M이 몇 개 나왔는지
            if(cur == 'K'){
                max.append("5" + "0".repeat(cnt));
                cnt = 0;
            }else{
                cnt++;
            }
        }
        // 마지막이 M일 경우
        if(cnt > 0){
            max.append("1".repeat(cnt));
        }

        // 최솟값 찾기
        StringBuilder min = new StringBuilder();
        cnt = 0;
        for(int i = 0 ; i < input.length() ; i++){
            char cur = input.charAt(i);
            // M를 찾고 계산
            if(cur == 'M'){
                cnt++;
            }else{
                if (cnt > 0) {
                    min.append("1" + "0".repeat(cnt - 1));
                }
                min.append("5");
                cnt = 0;
            }
        }

        // 마지막이 M인 경우
        if (cnt > 0) {
            min.append("1" + "0".repeat(cnt - 1));
        }

        System.out.println(max.toString());
        System.out.println(min.toString());

    } 
}
