import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> rcd = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int r = rcd.get(0);
        int c = rcd.get(1);
        int d = rcd.get(2);

        List<List<Integer>> room = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            room.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        int cnt = 0;

        while (true) {
            // 현재 칸을 본다
            int cur = room.get(r).get(c);
            if(cur == 0){
                // 청소
                cnt++;
                room.get(r).set(c, 2); // 2번은 청소가 완료된 칸
            }

            // 주변 4칸 확인
            int[] dy = new int[]{-1,0,1,0};
            int[] dx = new int[]{0,1,0,-1};
            boolean isPossible = false;
            for(int i = 0 ; i < 4 ; i++){
                int ny = r + dy[i];
                int nx = c + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M){
                    if(room.get(ny).get(nx) == 0){
                        isPossible = true;
                        break;
                    }
                }
            }

            // 빈 칸 존재
            if(isPossible){
                // 반시계방향 회전
                d -= 1;
                if(d < 0){
                    d = 3;
                }
                // 앞칸이 청소되지 않은 빈칸이면 전진
                int ny = r + dy[d];
                int nx = c + dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<M){
                    if(room.get(ny).get(nx) == 0){
                        r = ny;
                        c = nx;
                        continue;
                    }
                }
            }

            // 빈칸 존재하지 않음
            else{
                // 후진 가능한 경우
                int ny = r - dy[d];
                int nx = c - dx[d];
                if(ny>=0&&ny<N&&nx>=0&&nx<M){
                    if(room.get(ny).get(nx) != 1){
                        r = ny;
                        c = nx;
                        continue;
                    }
                    else if(room.get(ny).get(nx) == 1){
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}


