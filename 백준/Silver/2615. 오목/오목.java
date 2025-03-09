import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[19][19];
        for(int i = 0; i < 19; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < 19 ; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 각 위치에서 승리 조건 확인
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(map[i][j] == 1 || map[i][j] == 2) {
                    if(winning(map, i, j)){
                        System.out.println(map[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean winning(int[][] map, int i, int j) {
        int color = map[i][j];
        
        // 가로 방향 확인
        if(j <= 14) { // 가로로 5개가 들어갈 수 있는 경우만 확인
            boolean win = true;
            // 왼쪽에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(j > 0 && map[i][j-1] == color) {
                win = false;
            }
            
            // 연속 5개 확인
            for(int k = 1; k < 5; k++) {
                if(map[i][j+k] != color) {
                    win = false;
                    break;
                }
            }
            
            // 오른쪽에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(j+5 < 19 && map[i][j+5] == color) {
                win = false;
            }
            
            if(win) return true;
        }
        
        // 세로 방향 확인
        if(i <= 14) { // 세로로 5개가 들어갈 수 있는 경우만 확인
            boolean win = true;
            // 위쪽에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i > 0 && map[i-1][j] == color) {
                win = false;
            }
            
            // 연속 5개 확인
            for(int k = 1; k < 5; k++) {
                if(map[i+k][j] != color) {
                    win = false;
                    break;
                }
            }
            
            // 아래쪽에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i+5 < 19 && map[i+5][j] == color) {
                win = false;
            }
            
            if(win) return true;
        }
        
        // 대각선 방향 (우상향) 확인
        if(i >= 4 && j <= 14) {
            boolean win = true;
            // 좌하단에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i < 18 && j > 0 && map[i+1][j-1] == color) {
                win = false;
            }
            
            // 연속 5개 확인
            for(int k = 1; k < 5; k++) {
                if(map[i-k][j+k] != color) {
                    win = false;
                    break;
                }
            }
            
            // 우상단에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i-5 >= 0 && j+5 < 19 && map[i-5][j+5] == color) {
                win = false;
            }
            
            if(win) return true;
        }
        
        // 대각선 방향 (우하향) 확인
        if(i <= 14 && j <= 14) {
            boolean win = true;
            // 좌상단에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i > 0 && j > 0 && map[i-1][j-1] == color) {
                win = false;
            }
            
            // 연속 5개 확인
            for(int k = 1; k < 5; k++) {
                if(map[i+k][j+k] != color) {
                    win = false;
                    break;
                }
            }
            
            // 우하단에 같은 색 돌이 없는지 확인 (6목 이상 방지)
            if(i+5 < 19 && j+5 < 19 && map[i+5][j+5] == color) {
                win = false;
            }
            
            if(win) return true;
        }
        
        return false;
    }
}
