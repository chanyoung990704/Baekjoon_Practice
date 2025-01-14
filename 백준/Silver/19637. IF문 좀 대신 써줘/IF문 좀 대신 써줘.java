import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<String[]> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine().split(" "));
        }

        StringBuilder sb = new StringBuilder();
        
        // 각 전투력에 대해
        for(int i = 0 ; i < M ; i++){
            int power = Integer.parseInt(br.readLine());
            
            // 이분탐색으로 해당 전투력에 맞는 첫 번째 칭호 찾기
            int lo = 0;
            int hi = N - 1;
            int result = 0;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int limit = Integer.parseInt(list.get(mid)[1]);

                if(power <= limit){
                    result = mid;
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
            
            sb.append(list.get(result)[0]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
