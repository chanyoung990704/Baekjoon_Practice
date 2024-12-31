import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int J = Integer.valueOf(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < J ; i++) list.add(Integer.valueOf(br.readLine()));

        int lo = 1;
        int hi = NM[1] + lo - 1;

        int cnt = 0;
        for(int cur : list){
            // 현재 바구니 안에 포함
            if(lo <= cur && cur <= hi) continue;

            // 왼쪽 이동
            int dist = -1;
            if(cur < lo){
                dist = Math.abs(cur - lo);
                cnt += dist;
                lo -= dist;
                hi -= dist;
            }

            // 오른쪽
            if(cur > hi){
                dist = Math.abs(cur - hi);
                cnt += dist;
                lo += dist;
                hi += dist;
            }
        }
        
        System.out.println(cnt);

        br.close();


    }
}