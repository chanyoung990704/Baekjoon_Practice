

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] Ndkc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Ndkc[0];
        int d = Ndkc[1];
        int k = Ndkc[2];
        int c = Ndkc[3];

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums.addAll(new ArrayList<>(nums));
        nums.remove(nums.size() - 1);

        // 투포인터
        int lo = 0;
        int hi = 0;
        int s = 0; // 서로 다른 종류
        int cnt = 0; // 전체 종류
        Map<Integer, Integer> map = new HashMap<>(); // 가짓 수
        int max = Integer.MIN_VALUE;


        while (hi < nums.size()) {
            int cur = nums.get(hi);
            // 추가
            if(!map.containsKey(cur)) {
                s++;
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            cnt++;

            while (cnt >= k) {
                // 줄여야 함
                int remove = nums.get(lo);
                boolean coupon = map.containsKey(c);

                if(coupon) {
                    max = Math.max(max, s);
                }else{
                    max = Math.max(max, s + 1);
                }

                // 가짓수가 많으면
                if(map.get(remove) > 1) {
                    map.put(remove, map.get(remove) - 1);
                }else{
                    // 맵에서 삭제
                    map.remove(remove);
                    s--;
                }

                cnt--;
                lo++;
            }


            hi++;
        }

        System.out.println(max);
    }
}
