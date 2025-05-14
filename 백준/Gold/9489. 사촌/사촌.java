import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] nk = line.split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            if (n == 0 && k == 0) {
                break;
            }

            String[] numsStr = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int[] parent = new int[n];
            int idx = 0;
            int kidx = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] == k) {
                    kidx = i;
                }

                if (i == n - 1) {
                    parent[i] = idx;
                    break;
                }
                parent[i] = idx;
                // 연속이 끊어지면 idx 증가
                if (nums[i + 1] - nums[i] > 1) {
                    idx++;
                }
            }

            BitSet notK = new BitSet(n);
            for (int i = 0; i < n; i++) {
                if (parent[i] == 0) {
                    notK.set(i);
                }
            }

            // 0인 경우
            if (notK.get(kidx)) {
                System.out.println(0);
                continue;
            }

            int kParentIdx = parent[kidx];
            int kGrandParentIdx = parent[kParentIdx];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (!notK.get(i) && parent[i] != kParentIdx && parent[parent[i]] == kGrandParentIdx) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
