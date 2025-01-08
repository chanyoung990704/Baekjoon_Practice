import java.util.*;

class Solution {
    int[][] key, lock;

    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;

        int M = key.length;
        int N = lock.length;

        // 확장된 자물쇠 생성
        int[][] extendedLock = new int[3 * N][3 * N];
        for (int i = N; i < 2 * N; i++) {
            for (int j = N; j < 2 * N; j++) {
                extendedLock[i][j] = lock[i - N][j - N];
            }
        }

        // 열쇠 이동 및 회전
        for (int sy = 0; sy < 2 * N; sy++) { // 범위 수정
            for (int sx = 0; sx < 2 * N; sx++) { // 범위 수정

                for (int cnt = 0; cnt < 4; cnt++) { // 회전 4번 수행
                    turnKey();

                    // 열쇠 삽입
                    if (insertKeyAndCheck(extendedLock, sy, sx)) return true;

                    // 열쇠 제거
                    removeKey(extendedLock, sy, sx);
                }
            }
        }

        return false;
    }

    boolean insertKeyAndCheck(int[][] extendedLock, int sy, int sx) {
        int M = key.length;
        int N = lock.length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                extendedLock[i + sy][j + sx] += key[i][j];
            }
        }

        // 중앙 영역 확인
        return isAll(extendedLock, N);
    }

    void removeKey(int[][] extendedLock, int sy, int sx) {
        int M = key.length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                extendedLock[i + sy][j + sx] -= key[i][j];
            }
        }
    }

    boolean isAll(int[][] exlock, int N) {
        for (int i = N; i < 2 * N; i++) {
            for (int j = N; j < 2 * N; j++) {
                if (exlock[i][j] != 1) return false;
            }
        }
        return true;
    }

    void turnKey() {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - i - 1] = key[i][j];
            }
        }
        key = rotated;
    }
}
