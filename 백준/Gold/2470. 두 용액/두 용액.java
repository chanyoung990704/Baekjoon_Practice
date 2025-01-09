import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int lo = -1;
        int hi = -1;
        int val = Integer.MAX_VALUE;

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        for(int i = 0 ; i < list.size() ; i++) {
            int cur = list.get(i);
            int target = -1 * cur;

            int idx = getIdx(list, target);

            if(idx < list.size() && idx != i){
                int v = Math.abs(list.get(i) + list.get(idx));
                if(v < val){
                    lo = Math.min(i, idx);
                    hi = Math.max(i, idx);
                    val = v;
                }
            }

            if(idx - 1 >= 0 && idx - 1 != i) {
                int v = Math.abs(list.get(i) + list.get(idx - 1));
                if(v < val){
                    lo = Math.min(i, idx - 1);
                    hi = Math.max(i, idx - 1);
                    val = v;
                }
            }
        }


        System.out.println(list.get(lo) + " " + list.get(hi));
    }

    // 이분탐색
    static int getIdx(List<Integer> list, int target){
        int lo = 0;
        int hi = list.size() - 1;
        int ret = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cur = list.get(mid);

            if(cur >= target) {
                ret = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return ret;
    }
}
