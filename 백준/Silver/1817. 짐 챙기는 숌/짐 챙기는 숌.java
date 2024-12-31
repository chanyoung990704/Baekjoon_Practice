import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        if(NM.get(0) == 0) {
            System.out.println(0);
            return;
        }

        List<Integer> books = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int M = NM.get(1);

        int saved = 0;
        int cnt = 1;

        for(int i = 0 ; i < books.size() ; i++){
            // 이전 상자에 계속 넣을 수 있다
            int cur = books.get(i);
            if(saved + cur <= M) saved += cur;
            else{
                cnt++;
                saved = cur;
            }
        }

        System.out.println(cnt);

        br.close();


    }
}