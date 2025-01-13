import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        // 10으로 나누어 지는 것들
        List<Integer> copied = list.stream().filter(i -> i % 10 == 0)
        .sorted().collect(Collectors.toList());

        // 10으로 나누어지지 않는 것들
        list = list.stream().filter(i -> i % 10 != 0)
        .sorted().collect(Collectors.toList());
    
        int cnt = 0;

        if(M > 0){
            int[] fir = getCnt(copied, M);
            cnt += fir[0];
            M = fir[1];    
        }

        if(M > 0){
            int[] sec = getCnt(list, M);
            cnt += sec[0];
        }

        System.out.println(cnt);

    } 


    static int[] getCnt(List<Integer> list, int M){
        int cnt = 0;
        int N = list.size();

        for(int i = 0 ; i < N ; i++) {
            int cur = list.get(i);
            // 10 이하면 생략
            if(cur < 10){
                continue;
            }

            // 자를 수 없으면 멈추기
            if(M == 0){
                break;
            }

            // 10이면 그냥 개수 증가
            if(cur == 10){
                cnt++;
                continue;
            }

            // 현재가 10으로 나누어 지면
            if(cur % 10 == 0){
                int max = cur / 10 - 1;
                // 최대만큼 자를 수 있으면
                if(max <= M){
                    M -= max;
                    cnt += cur / 10;
                }else{
                    cnt += M;
                    M = 0;
                }
            }
            else{
                int max = cur / 10;
                if(max <= M){
                    M -= max;
                    cnt += max;
                }else{
                    cnt += M;
                    M = 0;
                }
            }

        }

        return new int[]{cnt, M};
    }
}
