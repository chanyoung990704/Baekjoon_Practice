import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        // 0은 제외시키기
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).filter(i -> i != 0).collect(Collectors.toList());

        int cnt = 0;

        while (!list.isEmpty()) {
            
            // 바꾼 숫자가 모두 1인지 확인
            int curCnt = 0;
            // 전체 순회하면서 홀수면 짝수 만들기
            for(int i = 0 ; i < list.size() ; i++) {
                int cur = list.get(i);
                // 홀수
                if(cur % 2 == 1){
                    cnt++;
                    cur--;
                }
                if(cur == 0){
                    curCnt++;
                }
                list.set(i, cur);
            }

            if(curCnt != list.size()) {
                // 나누기 연산 실행하고 0은 생략
                cnt++;
                list = list.stream().map(i -> i / 2)
                .filter(i -> i != 0).collect(Collectors.toList());
            }
            else{
                break;
            }
        }


        System.out.println(cnt);
    }
}
