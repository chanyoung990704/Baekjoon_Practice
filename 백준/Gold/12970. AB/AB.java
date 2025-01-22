import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        // 예외
        if(N / 2 * (N - N / 2) < M){
            System.out.println(-1);
            return;
        }

        // A가 놓인 수
        int placed = 0;
        int cnt = 0;

        StringBuilder sb = new StringBuilder("B".repeat(N));
        for(int i = 0 ; i < sb.length() ; i++) {
            // 현재 A를 놓았을 때 최종 쌍
            int curCnt = (sb.length() - i - 1) + cnt - placed;
            
            if(curCnt < M){
                cnt = curCnt;
                placed++;
                sb.setCharAt(i, 'A');
            }else if(curCnt == M){
                cnt = curCnt;
                placed++;
                sb.setCharAt(i, 'A');
                break;
            }
        }

        if (cnt == M) {
            System.out.println(sb.toString());
        }
    }
}
