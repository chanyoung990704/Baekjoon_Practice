import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] houses;

    static int ret = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(houses);

        // 이분탐색
        int lo = 1, hi = 1000000000;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int cnt = 0;
            int idx = 0;
            // 첫번째 집부터 설치해서 개수 카운팅
            for (int house : houses) {
                if (idx <= house) {
                    // 설치
                    idx = house + mid;
                    cnt++;
                }
            }


            // C개보다 안되면 길이 줄이기
            if (cnt < C) {
                hi = mid - 1;
            }else{
                ret = Math.max(ret, mid);
                lo = mid + 1;
            }
        }

        System.out.println(ret);
    }
}
