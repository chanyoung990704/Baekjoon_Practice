import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> RCN = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int R = RCN.get(0);
        int C = RCN.get(1);
        int N = RCN.get(2);

        int time = 0;

        int[][] board = new int[R][C]; // -1은 빈칸, 0이상 숫자 폭탄
        for(int i = 0 ; i < R ; i++){
            String cur = br.readLine();
            for(int j = 0 ; j < cur.length() ; j++){
                if(cur.charAt(j) == 'O'){
                    board[i][j] = time;
                }else{
                    board[i][j] = -1;
                }
            }
        }

        while (time < N) {
            time++;
            // 처음 1초는 가만히 있는다.
            if(time == 1){
                continue;
            }
            if(time % 2 == 0){
                // 폭탄이 설치되어있지 않은 곳에 폭탄 설치
                for(int i = 0 ; i < R ; i++){
                    for(int j = 0 ; j < C ; j++){
                        if(board[i][j] == -1){
                            board[i][j] = time;
                        }
                    }
                }
            }
            else{
                int[] dy = new int[]{0,0,1,-1};
                int[] dx = new int[]{1,-1,0,0};
                List<List<Integer>> needBomb = new ArrayList<>();

                // 3초전에 설치된 폭탄과 인접 칸 찾기
                for(int i = 0 ; i < R ; i++){
                    for(int j = 0 ; j < C ; j++) {
                        if(board[i][j] == time - 3){
                            needBomb.add(List.of(i, j));
                            for(int dir = 0 ; dir < 4 ; dir++){
                                int ny = i + dy[dir];
                                int nx = j + dx[dir];
                                if(ny >= 0 && ny < R && nx >= 0 && nx < C){
                                   needBomb.add(List.of(ny,nx));
                                }
                            }
                        }
                    }
                }
                // 폭발 작업 진행
                for(List<Integer> b : needBomb){
                    board[b.get(0)][b.get(1)] = -1;
                }
            }
        }

        // 결과 출력
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                System.out.print(board[i][j] == -1 ? "." : "O");
            }
            System.out.println();
        }
    }
}


