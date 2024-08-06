import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class City{
        int idx;
        int cnt;

        City(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }

        int getIdx(){return idx;}
        int getCnt(){return cnt;}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NMKX = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();


        Deque<City> dq = new ArrayDeque<>();
        // 간선 정보입력
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= NMKX[0] ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < NMKX[1] ; i++){
            int[] fromTo = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();
            adj.get(fromTo[0]).add(fromTo[1]);
        }

        // BFS
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[NMKX[0] + 1];

        dq.offer(new City(NMKX[3], 0));
        visited[NMKX[3]] = true;

        while(!dq.isEmpty()){
            City cur = dq.pollFirst();

            if(cur.getCnt() > NMKX[2]) break;
            if(cur.getCnt() == NMKX[2]) result.add(cur.getIdx());

            for(int next : adj.get(cur.getIdx())){
                if(!visited[next]){
                    visited[next] = true;
                    dq.offer(new City(next, cur.getCnt() + 1));
                }
            }

        }
        
        if(result.isEmpty()){
            System.out.println(-1);
        }else{
            result.stream()
            .sorted()
            .forEach(System.out::println);
        }


        br.close();
    }
}