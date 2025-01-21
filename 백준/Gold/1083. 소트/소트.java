import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Long> list = Arrays.stream(br.readLine().split(" "))
        .map(Long::valueOf).collect(Collectors.toList());

        int S = Integer.valueOf(br.readLine());

        // 정렬 시도
        for(int i = 0 ; i < list.size() - 1 && S > 0 ; i++){  // S > 0 조건 추가
            int cnt = 0;
            int idx = i;
            
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

            if(cnt == 0){  // 현재가 최대이면 넘어가기
                continue;
            }

            // swap 함수 수정
            Long temp = list.get(idx);
            for(int j = idx ; j > i ; j--) {
                list.set(j, list.get(j-1));
            }
            list.set(i, temp);
            S -= cnt;
        }

        System.out.println(
            list.stream().map(String::valueOf)
            .collect(Collectors.joining(" "))
        );
    }
}
