import java.util.*;

class Solution {
    int len;
    int lockLen;

    public boolean solution(int[][] key, int[][] lock) {
        len = key.length;
        lockLen = lock.length;
        
        // lock 3배 확장 & 중앙에 lock 삽입
        int[][] newLock = new int[lockLen * 3][lockLen * 3];
        for (int i = 0; i < lockLen; i++)
            for (int j = 0; j < lockLen; j++)
                newLock[lockLen + i][lockLen + j] = lock[i][j];
        
        for (int turn = 0; turn < 4; turn++) {
            key = rotateKey(key); // 회전 후 key 업데이트
            
            for (int sy = 0; sy <= lockLen * 2; sy++) {
                for (int sx = 0; sx <= lockLen * 2; sx++) {
                    
                    // key를 newLock에 더하기
                    for (int i = 0; i < len; i++)
                        for (int j = 0; j < len; j++)
                            newLock[sy + i][sx + j] += key[i][j];
                    
                    // lock이 열리는지 확인
                    if (isOk(newLock)) return true;
                    
                    // key를 newLock에서 빼기
                    for (int i = 0; i < len; i++)
                        for (int j = 0; j < len; j++)
                            newLock[sy + i][sx + j] -= key[i][j];                    
                }
            }
        }
        
        return false;
    }
    
    boolean isOk(int[][] newLock) {
        for (int i = lockLen; i < lockLen * 2; i++)
            for (int j = lockLen; j < lockLen * 2; j++)
                if (newLock[i][j] != 1) return false; // 수정: 1인지 확인
        return true;
    }
    
    int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[len][len];
        
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                newKey[j][len - i - 1] = key[i][j];
        
        return newKey;
    }
}
