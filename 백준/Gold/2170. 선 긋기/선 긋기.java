import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        // Event 객체 대신 long 배열 사용 (메모리와 속도 최적화)
        long[] events = new long[2 * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 하위 1비트에 시작(0) / 끝(1) 정보를 담아 정렬 순서 제어
            // 음수 좌표 대응을 위해 비트 연산 대신 곱셈/나머지 연산 활용 가능
            events[2 * i] = (long) start * 2; 
            events[2 * i + 1] = (long) end * 2 + 1;
        }

        // Primitive 배열 정렬은 객체 정렬보다 월등히 빠름
        Arrays.sort(events);

        long section = 0;
        int sum = 0;
        int left = 0;

        for (long e : events) {
            // 값 복원: 짝수면 시작점, 홀수면 끝점
            // 음수 좌표에서도 올바르게 작동하도록 e >> 1 대신 / 2 사용 가능
            int curTime = (int) Math.floor((double) e / 2.0);
            int type = (e % 2 == 0) ? 1 : -1;

            if (sum == 0) {
                left = curTime;
            }

            sum += type;

            if (sum == 0) {
                section += (long) curTime - left;
            }
        }

        System.out.println(section);
    }
}