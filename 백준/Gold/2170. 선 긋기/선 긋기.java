import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        int N = Integer.parseInt(br.readLine()); // valueOf 대신 parseInt 사용
        int[][] lines = new int[N][2]; // List 대신 배열 사용
        
        // 입력 처리를 단순화
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            lines[i][0] = Integer.parseInt(input[0]);
            lines[i][1] = Integer.parseInt(input[1]);
        }
        
        // 시작점 기준 정렬
        Arrays.sort(lines, (a, b) -> a[0] - b[0]);
        
        int start = lines[0][0];
        int end = lines[0][1];
        int total = 0;
        
        // 선분 병합 및 길이 계산
        for(int i = 1; i < N; i++) {
            if(lines[i][0] <= end) {
                end = Math.max(end, lines[i][1]);
            } else {
                total += end - start;
                start = lines[i][0];
                end = lines[i][1];
            }
        }
        total += end - start;
        
        System.out.println(total);
        br.close(); // 리소스 해제
    }
}
