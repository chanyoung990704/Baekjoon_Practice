import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int lo = 1;
        int hi = N;
        int target = N;

        // 이분 탐색
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int prev = 0;
            boolean possible = true;
            // 불빛이 비치는지
            for(int i = 0 ; i < list.size() ; i++){
                int cur = list.get(i);
                // 이전보다 이하
                if(cur - mid <= prev){
                    prev = cur + mid;
                }else{
                    possible = false;
                    break;
                }
            }
            if(prev < N){
                possible = false;
            }

            if(possible){
                target = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }


        System.out.println(target);
    }
}
