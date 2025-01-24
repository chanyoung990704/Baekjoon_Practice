import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        // 뒤부터 탐색
        int cnt = 0;
        for(int i = list.size() - 2 ; i >= 0 ; i--){
            int cur = list.get(i);
            int after = list.get(i + 1);
            // 앞에 것보다 1 작게 만들어야 함
            if(cur >= after){
                cnt += Math.abs(after - cur);
                cnt++;
                list.set(i, after - 1);
            }
        }
        
        System.out.println(cnt);
    }
}
