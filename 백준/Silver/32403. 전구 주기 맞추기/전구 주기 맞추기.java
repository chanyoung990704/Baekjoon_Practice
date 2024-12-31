import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NT = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> n = new ArrayList<>(); // T의 약수 저장
        int T = NT.get(1);

        for(int i = 1 ; i <= Math.sqrt(T) ; i++){
            if(T % i == 0){
                n.add(i);
                if(T / i != i) n.add(T / i);
            }
        }

        Collections.sort(n);
        int cnt = 0;

        for(int target : nums){
            int lo = 0;
            int hi = n.size() - 1;
            int min = -1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int t = n.get(mid);

                if(target < t){
                    hi = mid - 1;
                }else{
                    min = t;
                    lo = mid + 1;
                }
            }

            lo = 0;
            hi = n.size() - 1;
            int max = -1;
            
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int t = n.get(mid);

                if(target <= t){
                    max = t;
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }

            cnt += Math.min(Math.abs(target - min), Math.abs(target - max));
        }

        System.out.println(cnt);
        br.close();
    }
}