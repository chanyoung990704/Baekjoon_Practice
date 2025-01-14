import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> MN = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int M = MN.get(0);
        int N = MN.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        long total = 0;
        for(int l : list){
            total += l;
        }

        // 이분 탐색
        long lo = 1;
        long hi = total / M;
        long ret = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            int cnt = 0;
            for(int i = 0 ; i < list.size() ; i++){
                long cur = Long.valueOf(list.get(i)) / mid;
                if(cur > 0){
                    cnt += cur;
                }else{
                    break;
                }
            }

            if(cnt >= M){
                ret = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        System.out.println(ret);

    }
}
