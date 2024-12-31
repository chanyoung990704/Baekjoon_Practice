import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> money = new ArrayList<>();
        for(int i = 0 ; i < NK.get(0) ; i++) money.add(Integer.valueOf(br.readLine()));

        int K = NK.get(1);
        int cnt = 0;

        while (K != 0) {
            int lo = 0;
            int hi = money.size() - 1;
            int val = -1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int target = money.get(mid);

                if(K >= target){
                    val = target;
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            
            cnt += (K / val);
            K %= val;
        }


        System.out.println(cnt);


        br.close();


    }
}