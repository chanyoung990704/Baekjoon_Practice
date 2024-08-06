import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int cnt0 = 0; // 0에서 1로 변경되는 횟수
        int cnt1 = 0; // 1에서 0으로 변경되는 횟수

        // 첫 번째 문자에 따라 초기 카운트 설정
        if (input.charAt(0) == '0') cnt1++;
        else cnt0++;

        // 연속된 숫자가 바뀔 때마다 카운트 증가
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i-1)) {
                if (input.charAt(i) == '0') cnt1++;
                else cnt0++;
            }
        }

        // 두 카운트 중 최소값 출력
        System.out.println(Math.min(cnt0, cnt1));

        br.close();
    }
}