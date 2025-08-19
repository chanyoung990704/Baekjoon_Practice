import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        // map
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        }

        // recursive
        String res = recursiveMap(map, 0, 0, N);

        System.out.println(res);
    }

    private static String recursiveMap(int[][] map, int y, int x, int size) {

        if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) {
            return "";
        }

        // basecase
        boolean allBlack = true;
        boolean allWhite = true;

        for(int i = y ; i < y + size; i++){
            for(int j = x ; j < x + size; j++){
                if(map[i][j] == 0){
                    allBlack = false;
                }
                if(map[i][j] == 1){
                    allWhite = false;
                }
            }
        }

        if (allWhite) {
            return "0";
        }

        if (allBlack) {
            return "1";
        }

        // divide
        int nextSize = size / 2;
        String upLeft = recursiveMap(map, y, x, nextSize);
        String upRight = recursiveMap(map, y, x + nextSize, nextSize);
        String downLeft = recursiveMap(map, y + nextSize, x, nextSize);
        String downRight = recursiveMap(map, y + nextSize, x + nextSize, nextSize);

        return "(" + upLeft + upRight + downLeft + downRight + ")";
    }
}
