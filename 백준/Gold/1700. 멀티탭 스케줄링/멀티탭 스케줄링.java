import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> plugged = new HashSet<>();
        int out = 0;

        for (int i = 0; i < K; i++) {
            if (plugged.contains(nums[i])) continue;

            if (plugged.size() < N) {
                plugged.add(nums[i]);
            } else {
                // 앞으로 등장하지 않는 플러그가 있으면 그걸, 없으면 가장 늦게 나오는 플러그를 뺀다
                int lastUsed = -1, farthest = -1;
                for (int p : plugged) {
                    int j;
                    for (j = i + 1; j < K; j++) {
                        if (nums[j] == p) break;
                    }
                    if (j > farthest) {
                        farthest = j;
                        lastUsed = p;
                    }
                }
                plugged.remove(lastUsed);
                plugged.add(nums[i]);
                out++;
            }
        }

        System.out.println(out);
    }
}
