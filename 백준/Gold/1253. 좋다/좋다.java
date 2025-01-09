import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());
        int cnt = 0;

        for(int i = 0 ; i < list.size() ; i++) {
            int target = list.get(i);

            int lo = 0;
            int hi = list.size() - 1;

            while (lo < hi) {
                if(lo == i) {
                    lo++;
                    continue;
                }
                if(hi == i) {
                    hi--;
                    continue;
                }

                int sum = list.get(lo) + list.get(hi);
                if(sum < target) lo++;
                else if(sum > target) hi --;
                else{
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
