import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int cnt = 1; // 자기 자신의 상자는 항상 꺼내야 하므로 1부터 시작

        int row = (num - 1) / w;
        int col = (row % 2 == 0) ? (num - 1) % w : w - 1 - ((num - 1) % w);

        // 위층에서 같은 col에 박스가 존재하면 카운트
        for (int r = row + 1; ; r++) {
            int boxNum;
            if (r % 2 == 0) {
                boxNum = r * w + col + 1;
            } else {
                boxNum = r * w + (w - 1 - col) + 1;
            }
            if (boxNum > n) break;
            cnt++;
        }
        return cnt;
    }
}
