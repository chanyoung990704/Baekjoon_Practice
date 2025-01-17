import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> timeTable = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            timeTable.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 카운트 배열
        int[] cnt = new int[366];

        for(List<Integer> t : timeTable){
            for(int i = t.get(0) ; i <= t.get(1) ; i++){
                cnt[i]++;
            }
        }

        // 직사각형 찾기
        int w = 0;
        int h = 0;
        long total = 0;

        for(int i = 1 ; i <= 365 ; i++) {
            // 카운팅이 되었다면 직사각형 만들어야
            if(cnt[i] > 0){
                w++;
                h = Math.max(h, cnt[i]);
            }else{
                // 지금까지 직사각형
                total += w * h;
                w = 0;
                h = 0;
            }
        }

        total += w * h;

        System.out.println(total);


    }
}
