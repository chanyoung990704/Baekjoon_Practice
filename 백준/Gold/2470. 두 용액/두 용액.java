import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int lo = -1;
        int hi = -1;
        int val = Integer.MAX_VALUE;

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).sorted().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            int target = -cur;

            // 이분 탐색으로 target 이상인 첫 번째 값의 인덱스 찾기
            int idx = getIdx(list, target);

            // 현재 값과 idx 값의 합 계산
            if (idx < list.size() && idx != i) {
                int v = Math.abs(list.get(i) + list.get(idx));
                if (v < val) {
                    val = v;
                    lo = Math.min(i, idx);
                    hi = Math.max(i, idx);
                }
            }

            // idx-1 값도 확인
            if (idx - 1 >= 0 && idx - 1 != i) {
                int v = Math.abs(list.get(i) + list.get(idx - 1));
                if (v < val) {
                    val = v;
                    lo = Math.min(i, idx - 1);
                    hi = Math.max(i, idx - 1);
                }
            }
        }

        System.out.println(list.get(lo) + " " + list.get(hi));
    }

    // 이분 탐색: target 이상인 첫 번째 값의 인덱스를 반환
    static int getIdx(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo; // target 이상인 첫 번째 위치를 반환
    }
}
