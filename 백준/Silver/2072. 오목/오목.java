import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> idxs = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            idxs.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        // 흑 1 백 -1
        int[][] graph = new int[20][20];
        int cnt = 1;

        for(List<Integer> idx : idxs){
            // 바둑 놓기
            graph[idx.get(0)][idx.get(1)] = 
            cnt % 2 == 0 ? -1 : 1;

            // 상하 dfs
            if(updown(graph, idx.get(0), idx.get(1), new boolean[20][20]) == 5){
                break;
            }
            // 좌우 dfs
            if(leftright(graph, idx.get(0), idx.get(1), new boolean[20][20]) == 5){
                break;
            }
            
            // 오른쪽 대각
            if(rightdiag(graph, idx.get(0), idx.get(1), new boolean[20][20]) == 5){
                break;
            }

            // 왼쪽 대각
            if(leftdiag(graph, idx.get(0), idx.get(1), new boolean[20][20]) == 5){
                break;
            }
            cnt++;
        }
        
        System.out.println(cnt > N ? -1 : cnt);

    }

    static int updown(int[][] graph, int y, int x, boolean[][] visited){

        int cnt = 1;
        visited[y][x] = true;
        // 위 dfs 체크
        if(y - 1 >= 1 && !visited[y - 1][x] && graph[y - 1][x] == graph[y][x]){
            cnt += updown(graph, y - 1, x, visited);
        }

        // 아래 dfs 체크
        if(y + 1 < 20 && !visited[y + 1][x] && graph[y + 1][x] == graph[y][x]){
            cnt += updown(graph, y + 1, x, visited);
        }

        return cnt;
    }

    static int leftright(int[][] graph, int y, int x, boolean[][] visited){

        int cnt = 1;
        visited[y][x] = true;
        // 왼쪽 dfs 체크
        if(x - 1 >= 1 && !visited[y][x - 1]&& graph[y][x - 1] == graph[y][x]){
            cnt += leftright(graph, y, x - 1, visited);
        }

        // 오른쪽 dfs 체크
        if(x + 1 < 20 && !visited[y][x + 1] && graph[y][x + 1] == graph[y][x]){
            cnt += leftright(graph, y, x + 1, visited);
        }

        return cnt;
    }


    static int rightdiag(int[][] graph, int y, int x, boolean[][] visited){

        int cnt = 1;
        visited[y][x] = true;
        // 오른쪽 위 dfs 체크
        if(x + 1 < 20 && y - 1 >= 1 &&
         !visited[y - 1][x + 1]&& graph[y - 1][x + 1] == graph[y][x]){
            cnt += rightdiag(graph, y - 1, x + 1, visited);
        }

        // 왼쪽 아래 dfs 체크
        if(x - 1 >= 1 && y + 1 < 20 && 
        !visited[y + 1][x - 1] && graph[y + 1][x - 1] == graph[y][x]){
            cnt += rightdiag(graph, y + 1, x - 1, visited);
        }

        return cnt;
    }    

    static int leftdiag(int[][] graph, int y, int x, boolean[][] visited){

        int cnt = 1;
        visited[y][x] = true;
        // 왼쪽 위 dfs 체크
        if(x - 1 >= 1 && y - 1 >= 1 &&
        !visited[y - 1][x - 1]&& graph[y - 1][x - 1] == graph[y][x]){
            cnt += leftdiag(graph, y - 1, x - 1, visited);
        }

        // 오른쪽 아래 dfs 체크
        if(x + 1 < 20 && y + 1 < 20 &&
        !visited[y + 1][x + 1] && graph[y + 1][x + 1] == graph[y][x]){
            cnt += leftdiag(graph, y + 1, x + 1, visited);
        }

        return cnt;
    }
}


