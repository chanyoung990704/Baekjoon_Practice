import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> nm = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nm.get(0);
        int m = nm.get(1);

        int[][] arr = new int[n][m];
        int sy = 0;
        int sx = 0;
        for(int i = 0 ; i < n ; i++){
            int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf).toArray();

            for(int j = 0 ; j < nums.length ; j++){
                arr[i][j] = nums[j];
                if(arr[i][j] == 2){
                    sy = i;
                    sx = j;
                }
            }
        }



        // 0,0부터 BFS
        int[][] res = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(res[i], -1);
        }
        res[sy][sx] = 0;
        Deque<List<Integer>> dq = new ArrayDeque<>();
        dq.offer(List.of(sy,sx,0));

        while (!dq.isEmpty()) {
            List<Integer> cur = dq.pollFirst();

            int[] dy = new int[]{0,0,1,-1};
            int[] dx = new int[]{1,-1,0,0};

            for(int i = 0 ; i < 4 ; i++){
                int ny = cur.get(0) + dy[i];
                int nx = cur.get(1) + dx[i];

                if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                    if(res[ny][nx] == -1 && arr[ny][nx] == 1){
                        res[ny][nx] = cur.get(2) + 1;
                        dq.offer(List.of(ny,nx,cur.get(2) + 1));
                    }
                }
            }
        }

        // 결과
        int[][] ret = new int[n][m];

        for(int i = 0 ; i < n;  i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == 0){
                    ret[i][j] = 0;
                    continue;
                }
                ret[i][j] = res[i][j];
            }
        }

        for(int i = 0 ; i < n;  i++){
            System.out.println(Arrays.stream(ret[i])
            .mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }

    }
}


