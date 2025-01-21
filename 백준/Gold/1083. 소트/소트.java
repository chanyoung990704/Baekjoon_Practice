import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Long> list = Arrays.stream(br.readLine().split(" "))
        .map(Long::valueOf).collect(Collectors.toList());

        int S = Integer.valueOf(br.readLine());

        // 정렬 시도
        for(int i = 0 ; i < list.size() - 1 ; i++){
            int cnt = 0;
            int idx = i;
            if(S <= 0){
                break;
            }
            for(int j = i + 1 ; j < list.size() ; j++) {
                int curCnt = (j - i);
                if(curCnt > S){
                    break;
                }
                if(list.get(idx) < list.get(j)){
                    cnt = curCnt;
                    idx = j;
                }
            }

            // 현재가 최대이면 넘어가기
            if(cnt == 0 && idx == i){
                continue;
            }

            // idx부터 i까지 스왑
            swap(list, idx, i);
            S -= cnt;
        }

        System.out.println(
            list.stream().map(String::valueOf)
            .collect(Collectors.joining(" "))
        );
    }

    static void swap(List<Long> list, int end, int start) {
        for(int i = end ; i > start ; i--) {
            Long tmp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, tmp);
        }
    }
}
