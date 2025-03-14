
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Map<Integer, Map<String ,Integer>> map = new HashMap<>(); // R 인덱스, Left : R 이전 왼쪽 K개수, Right : R 이후 K 개수

        List<Integer> idxs = new ArrayList<>(); // R 나오는 좌표
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'R') {
                idxs.add(i);
            }
        }

        // 왼쪽
        int leftK = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == 'K') {
                leftK++;
                continue;
            }
            map.computeIfAbsent(i, k -> new HashMap<>()).put("left", leftK);
        }

        // 오른쪽
        int rightK = 0;
        for(int i = str.length() - 1 ; i >= 0 ; i--) {
            char cur = str.charAt(i);
            if (cur == 'K') {
                rightK++;
                continue;
            }
            map.computeIfAbsent(i, k -> new HashMap<>()).put("right", rightK);
        }

        int lo = 0;
        int hi = idxs.size() - 1;
        int max = 0;  // 최소값은 0으로 설정

        while (lo <= hi) {

            int leftIdx = idxs.get(lo);
            int rightIdx = idxs.get(hi);

            Map<String, Integer> lMap = map.get(leftIdx);
            Map<String, Integer> rMap = map.get(rightIdx);

            int rCnt = hi - lo + 1;
            int leftKCnt = lMap.get("left");
            int rightKCnt = rMap.get("right");

            max = Math.max(max, Math.min(leftKCnt, rightKCnt) * 2 + rCnt);

            if (leftKCnt <= rightKCnt) {
                lo++;
            }else{
                hi--;
            }
        }


        System.out.println(max);
    }
}
