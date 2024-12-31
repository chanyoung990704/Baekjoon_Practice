import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // N과 M 읽기
            List<Integer> NM = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList());

            int N = NM.get(0);
            int M = NM.get(1);

            // 종료 조건 확인
            if (N == 0 && M == 0) break;

            List<Integer> sang = new ArrayList<>(); // 상근
            List<Integer> suny = new ArrayList<>(); // 선영

            for (int i = 0; i < N; i++) sang.add(Integer.valueOf(br.readLine()));
            for (int i = 0; i < M; i++) suny.add(Integer.valueOf(br.readLine()));

            int cnt = 0;

            for (int i = 0; i < sang.size(); i++) {
                int target = sang.get(i);

                int lo = 0;
                int hi = suny.size() - 1;
                int v = -1;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int s = suny.get(mid); // 선영이의 값

                    if (target >= s) {
                        if (target == s) v = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                if (v != -1) cnt++;
            }

            System.out.println(cnt);
        }

        br.close();
    }
}
