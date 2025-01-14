import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            List<Integer> NM = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            int N = NM.get(0);
            int M = NM.get(1);

            List<Integer> A = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            List<Integer> B = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).sorted().collect(Collectors.toList());

            int cnt = 0;

            for(int i = 0 ; i < A.size() ; i++){
                int target = A.get(i);
                // 이분 탐색
                int lo = 0;
                int hi = B.size() - 1;

                // 자기보다 작은 값이 없는 경우
                if(target < B.get(0)){
                    continue;
                }

                int v = 0;

                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    int cur = B.get(mid);

                    if(target <= cur){
                        hi = mid - 1;
                    }else{
                        v = mid;
                        lo = mid + 1;
                    }
                }

                if(B.get(v) == target){
                    continue;
                }

                cnt += (v + 1);
            }

            System.out.println(cnt);
        }

    }
}
