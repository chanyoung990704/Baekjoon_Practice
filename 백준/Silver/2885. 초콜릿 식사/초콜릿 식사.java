import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        int v = 1;
        while (v <= 10000000) {
            list.add(v);
            v *= 2;
        }

        int lo = 0;
        int hi = list.size() - 1;
        int idx = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if(K > list.get(mid)){
                lo = mid + 1;
            }else{
                idx = mid;
                hi = mid - 1;
            }
        }

        int len = list.get(idx);
        int take = 0;
        int cnt = 0;

        while (K > 0) {
            if(len > K){
                len /= 2;
                cnt++;
            }else{
                K -= len;
                len /= 2;
                cnt++;
            }
        }

        System.out.println(list.get(idx) + " " + --cnt);
    }
}