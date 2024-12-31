import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] AB = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) list.add(Integer.valueOf(br.readLine()));

        // 가장 절댓값이 작은 것을 시작점으로 
        int cnt = 0;
        int start = AB[0];
        int end = AB[1];
        int dist = Math.abs(start - end);

        for(int cur : list)
            if(Math.abs(cur - end) < dist){
                start = cur;
                dist = Math.abs(cur - end);
            }

        if(start != AB[0]) cnt = 1;
        
        System.out.println(cnt + dist);



        br.close();


    }
}