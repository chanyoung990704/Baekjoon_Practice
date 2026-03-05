import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 시작점 끝점
        int start =1, end = H+1;

        // 누적합
        int[] prefixSum = new int[end+2];
        prefixSum[0] = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            // 석순
            if(i%2==0){
                // 시작점 +1, 끝점에 -1 기록
                prefixSum[1] += 1;
                if(cur+1 < prefixSum.length){
                    prefixSum[cur+1] -= 1;
                }
            }
            // 증류석
            else{
                prefixSum[end] -= 1;
                if(end - cur >= 0){
                    prefixSum[end-cur] += 1;
                }
            }
        }

        // 누적합 구하기
        for(int i = 1 ; i < prefixSum.length ; i++){
            prefixSum[i] += prefixSum[i-1]; 
        }

        // 장애물 최소
        int min = IntStream.range(1, H+1).map(i -> prefixSum[i])
        .min().getAsInt();
        // 구간 수
        long cnt = IntStream.range(1, H+1).filter(i -> prefixSum[i] == min).count();

        System.out.println(min + " " + cnt);
        
    } 
}
