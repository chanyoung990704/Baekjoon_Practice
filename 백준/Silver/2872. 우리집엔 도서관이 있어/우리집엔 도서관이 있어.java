import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        int cnt = 0;
        int correct = N;  // 현재 확인해야 할 올바른 숫자

        // 아래서부터 올바른 연속된 숫자들 찾기
        for(int i = N-1; i >= 0; i--) {
            if(list.get(i) == correct) {
                correct--;
            } else {
                cnt++;
            }
        }

        System.out.println(cnt);
    } 
}
