import java.util.*;

class Solution {
    int[] answer;
    int l, n;
    long maxWins = -1; // 승리 횟수는 int 범위를 넘을 수 있음
    int[][] dice;
    int maxVal = 0;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;
        this.l = n / 2;

        // 1. 주사위 눈의 최대값 찾기 (배열 크기 결정용)
        for (int[] d : dice) {
            for (int v : d) maxVal = Math.max(maxVal, v);
        }

        // 2. 조합 탐색 시작
        comb(0, 0, 0);
        return answer;
    }

    void comb(int idx, int selected, int cnt) {
        if (cnt == l) {
            calculateWins(selected);
            return;
        }

        for (int i = idx; i < n; i++) {
            if ((selected & (1 << i)) == 0) {
                comb(i + 1, selected | (1 << i), cnt + 1);
            }
        }
    }

    void calculateWins(int selected) {
        int maxSum = maxVal * l;
        int[] aFreq = new int[maxSum + 1];
        int[] bFreq = new int[maxSum + 1];

        // A와 B의 가능한 모든 합의 빈도수 계산
        generateSumFreq(0, 0, 0, selected, aFreq, true);
        generateSumFreq(0, 0, 0, selected, bFreq, false);

        // B의 빈도수를 누적합으로 변환
        long[] bPrefixSum = new long[maxSum + 1];
        for (int i = 1; i <= maxSum; i++) {
            bPrefixSum[i] = bPrefixSum[i - 1] + bFreq[i - 1];
        }

        // A가 이기는 총 횟수 계산
        long currentWins = 0;
        for (int i = 0; i <= maxSum; i++) {
            if (aFreq[i] > 0) {
                currentWins += (long) aFreq[i] * bPrefixSum[i];
            }
        }

        if (currentWins > maxWins) {
            maxWins = currentWins;
            storeAnswer(selected);
        }
    }

    // 주사위 합의 빈도
    void generateSumFreq(int diceIdx, int currentSum, int cnt, int selected, int[] freq, boolean isA) {

        if (cnt == l) {
            freq[currentSum]++;
            return;
        }
        
        if(diceIdx >= n){
            return;
        }
        
        // 현재 인덱스의 주사위가 내가 찾고자 하는 팀의 것인지 확인
        while (diceIdx < n) {
            boolean isSelected = (selected & (1 << diceIdx)) != 0;
            if (isSelected == isA) {
                for (int val : dice[diceIdx]) {
                    generateSumFreq(diceIdx + 1, currentSum + val, cnt + 1, selected, freq, isA);
                }
            }
            diceIdx++;
        }
    }

    void storeAnswer(int selected) {
        answer = new int[l];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if ((selected & (1 << i)) != 0) answer[idx++] = i + 1;
        }
    }
}