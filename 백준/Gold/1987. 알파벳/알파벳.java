import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] RC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = RC[0];
        int C = RC[1];

        String[] m = new String[R];
        for(int i = 0; i < R; i++){
            m[i] = br.readLine();
        }

        Set<Character> set = new HashSet<>();
        set.add(m[0].charAt(0));
        System.out.println(dfs(0,0,m, set));
    }

    private static int dfs(int y, int x, String[] m, Set<Character> visited) {

        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};

        int cnt = 1;
        int max = 0;
        for(int i = 0; i < 4; i++){
            int ny = y +  dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < m.length && nx >= 0 && nx < m[0].length()) {
                if(!visited.contains(m[ny].charAt(nx))){
                    visited.add(m[ny].charAt(nx));
                    max = Math.max(max, dfs(ny, nx, m, visited));
                    visited.remove(m[ny].charAt(nx));
                }
            }
        }

        return cnt + max;
    }
}
