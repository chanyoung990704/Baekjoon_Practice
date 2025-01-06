import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.valueOf(br.readLine());

        int cnt = 1;

        int ty = 0;
        int tx = 0;

        int[] dy = new int[]{1, -1};
        int[] dx = new int[]{-1, 1};
        int dir = 1;

        while (cnt < X) {
            cnt++;
            
            ty += dy[dir];
            tx += dx[dir];
            
            if(tx < 0){
                tx = 0;
                dir = 1;
            }else if(ty < 0){
                ty = 0;
                dir = 0;
            }

        }

        System.out.println((ty + 1) + "/" + (tx + 1));
    }

}