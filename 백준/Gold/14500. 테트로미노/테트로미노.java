

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 테트로미노 모양 정의 (7가지 기본 모양과 회전/대칭 형태)
        int[][][] tetromino = {
            // I 모양 (LineShape)
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},  // 가로
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},  // 세로
            
            // O 모양 (SquareShape)
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
            
            // T 모양 (TShape)
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},  // 아래
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},  // 오른쪽
            {{1, 0}, {0, 1}, {1, 1}, {2, 1}},  // 위
            {{1, 0}, {0, 1}, {1, 1}, {1, 2}},  // 왼쪽
            
            // L 모양 (LShape)
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},  // 오른쪽 아래
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},  // 왼쪽 위
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},  // 왼쪽 아래
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}},  // 오른쪽 위
            
            // 미러링된 L 모양 (MirroredLShape)
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},  // 왼쪽 아래
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},  // 오른쪽 아래
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}},  // 오른쪽 위
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},  // 왼쪽 위
            
            // Z 모양 (ZShape)
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},  // 가로
            {{1, 0}, {0, 1}, {1, 1}, {0, 2}},  // 세로
            
            // S 모양 (SShape)
            {{1, 0}, {2, 0}, {0, 1}, {1, 1}},  // 가로
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}   // 세로
        };

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 모든 테트로미노 모양 시도
                for (int k = 0; k < tetromino.length; k++) {
                    int sum = 0;
                    boolean possible = true;
                    
                    for (int l = 0; l < 4; l++) {
                        int ny = i + tetromino[k][l][0];
                        int nx = j + tetromino[k][l][1];
                        
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                            possible = false;
                            break;
                        }
                        
                        sum += arr[ny][nx];
                    }
                    
                    if (possible) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
