import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{1, -1, 0, 0};
    static List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" "))
                         .mapToInt(Integer::valueOf)
                         .toArray();
        
        // map 입력
        for(int i = 0 ; i < NK[0] ; i++)
            map.add(Arrays.stream(br.readLine().split(" "))
                          .map(Integer::valueOf)
                          .collect(Collectors.toList()));
        
        // 우선순위 큐에 삽입  바이러스 번호, y축, x축, 횟수
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.get(3) != b.get(3)) return a.get(3) - b.get(3);
            else return a.get(0) - b.get(0);
        });

        for(int i = 0 ; i < NK[0] ; i++)
            for(int j = 0 ; j < NK[0] ; j++)
                if(map.get(i).get(j) != 0) pq.offer(List.of(map.get(i).get(j), i, j, 0));

        // 탐색 값
        List<Integer> search = Arrays.stream(br.readLine().split(" "))
                                     .map(Integer::valueOf)
                                     .collect(Collectors.toList());

        // BFS
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            if(cur.get(3) == search.get(0)) break;

            for(int i = 0 ; i < 4 ; i++){
                int ny = cur.get(1) + dy[i];
                int nx = cur.get(2) + dx[i];
                if(isBoundary(ny, nx) && map.get(ny).get(nx) == 0){
                    map.get(ny).set(nx, cur.get(0));
                    pq.offer(List.of(cur.get(0), ny, nx, cur.get(3) + 1));
                }
            }
        }

        System.out.println(map.get(search.get(1) - 1).get(search.get(2) - 1));

        br.close();
    }

    static boolean isBoundary(int y, int x){
        return y >= 0 && y < map.size() && x >= 0 && x < map.get(0).size();
    }
}