import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum();
        int groupCount = Math.min((minerals.length + 4) / 5, totalPicks);
        int[][] fatigues = new int[groupCount][3];
        int answer = 0;

        // 광물을 5개씩 그룹화하고 각 곡괭이로 캘 때의 피로도 계산
        for (int i = 0; i < groupCount; i++) {
            for (int j = i * 5; j < Math.min(minerals.length, i * 5 + 5); j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) {
                    fatigues[i][0] += 1;
                    fatigues[i][1] += 5;
                    fatigues[i][2] += 25;
                } else if (mineral.equals("iron")) {
                    fatigues[i][0] += 1;
                    fatigues[i][1] += 1;
                    fatigues[i][2] += 5;
                } else {
                    fatigues[i][0] += 1;
                    fatigues[i][1] += 1;
                    fatigues[i][2] += 1;
                }
            }
        }

        // 돌 곡괭이로 캘 때의 피로도를 기준으로 내림차순 정렬
        Arrays.sort(fatigues, (a, b) -> b[2] - a[2]);

        // 가장 좋은 곡괭이부터 할당
        for (int[] fatigue : fatigues) {
            if (picks[0] > 0) {
                answer += fatigue[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += fatigue[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += fatigue[2];
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }
}