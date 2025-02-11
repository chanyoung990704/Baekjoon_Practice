import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {

    static int cnt = 0;
    static int ret = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> Nrc = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = Nrc.get(0);
        int r = Nrc.get(1);
        int c = Nrc.get(2);

        int len = (int)Math.pow(2, N);
        travel(0, 0, len, r, c);

        System.out.println(ret - 1);
    }

    static void travel(int y, int x, int len, int r, int c){
        // 길이가 2인 경우
        if(len == 2){
            // 현재 방문
            cnt++;
            if(y == r && x == c){
                ret = cnt;
            }
            // 오른쪽 아래 대각 탐색
            int[] dy = new int[]{0,1,1};
            int[] dx = new int[]{1,0,1};
            for(int i = 0 ; i < 3 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                cnt++;
                if(ny == r && nx == c){
                    ret = cnt;
                }
            }
            return;
        }

        // 다음 단계 준비
        int nextLen = len / 2;
        // 왼쪽
        if(r < y + nextLen && c < x + nextLen){
            travel(y, x, nextLen, r, c);
        }
        // 오른쪽
        if(r < y + nextLen && c >= x + nextLen){
            cnt += nextLen * nextLen;
            travel(y, x + nextLen, nextLen, r, c);
        }
        // 아래
        if(r >= y + nextLen && c < x + nextLen){
            cnt += 2 * nextLen * nextLen;
            travel(y + nextLen, x, nextLen, r, c);
        }
        // 대각
        if(r >= y + nextLen && c >= x + nextLen){
            cnt += 3 * nextLen * nextLen;
            travel(y + nextLen, x + nextLen, nextLen, r, c);
        }
    }
}


