import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NL = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NL.get(0);
        int L = NL.get(1);
     
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());   


        // init
        int prev = 0;
        int cnt = 0;
        list.sort(Comparator.naturalOrder());

        for(int i = 0 ; i < list.size() ; i++){
            // 기존의 테이프 범위를 넘으면
            if(prev < list.get(i)){
                cnt++;
                prev = list.get(i) + L - 1;
            }
        }

        System.out.println(cnt);

        br.close();

    }
}
