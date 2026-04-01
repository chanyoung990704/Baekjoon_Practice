import java.util.*;

class Solution {
    int[][] cost, hint;
    int n;

    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        this.n = cost.length;
        return dfs(1, 0, new int[n + 1]);
    }

    int dfs(int stage, int sum, int[] hints) {
        if (stage == n + 1) return sum;

        int usedHints = Math.min(hints[stage], n - 1);
        int currentCost = cost[stage - 1][usedHints];

        int res = dfs(stage + 1, sum + currentCost, hints);

        if (stage < n) {
            int[] addHint = Arrays.copyOf(hints, hints.length);
            int bundlePrice = hint[stage - 1][0];
            
            for (int i = 1; i < hint[stage - 1].length; i++) {
                int targetStage = hint[stage - 1][i];
                addHint[targetStage]++;
            }
            
            res = Math.min(res, dfs(stage + 1, sum + currentCost + bundlePrice, addHint));
        }

        return res;
    }
}