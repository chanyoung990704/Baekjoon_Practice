import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            List<Integer> NXY = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
            int N = NXY.get(0);
            int X = NXY.get(1);
            int Y = NXY.get(2);

            List<Integer> speeds = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

            // 다른 참가자들의 최고 속도 계산
            List<Integer> sublist = speeds.subList(0, N - 1);
            int maxSpeed = Collections.max(sublist);

            // 내 기본 속도
            int mySpeed = speeds.get(N - 1);

            // 다른 참가자들의 최소 시간 계산
            double minTime = (double) X / maxSpeed;

            // 부스터 없이 내 시간 계산
            double myTimeWithoutBoost = (double) X / mySpeed;

            // 부스터 없이 단독 우승 가능한 경우
            if (myTimeWithoutBoost < minTime) {
                System.out.println(0);
                continue;
            }

            // 부스터 최대치로도 단독 우승 불가능한 경우
            double maxBoostedTime = (double) (X - Y) / mySpeed + 1;
            if (maxBoostedTime >= minTime) {
                System.out.println(-1);
                continue;
            }

            // 이진 탐색으로 최소 Z값 찾기
            int lo = 0;
            int hi = Y;
            int ret = -1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                double timeWithBoost = (double) (X - mid) / mySpeed + 1;

                if (timeWithBoost < minTime) {
                    ret = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(ret);
        }

        br.close();
    }
}
