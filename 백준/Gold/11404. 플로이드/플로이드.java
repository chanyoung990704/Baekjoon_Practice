import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Bus{
        int end;
        int cost;

        Bus(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        int getCost(){return cost;}
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());

        List<List<Bus>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++){
            int[] fromToCost = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();

            adj.get(fromToCost[0])
            .add(new Bus(fromToCost[1], fromToCost[2]));
        }

        int[] dist = new int[n + 1];

        for(int i = 1 ; i <= n ; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparing(Bus::getCost));
            pq.offer(new Bus(i, 0));

            while(!pq.isEmpty()){
                Bus cur = pq.poll();
                if(cur.cost > dist[cur.end]) continue;

                for(Bus next : adj.get(cur.end)){
                    int nextCost = next.cost + cur.cost;
                    if(dist[next.end] > nextCost){
                        dist[next.end] = nextCost;
                        pq.offer(new Bus(next.end, nextCost));
                    }
                }
            }

            String res = IntStream.range(1, n + 1)
            .mapToObj(d -> {
                if(dist[d] == Integer.MAX_VALUE) return "0";
                else return String.valueOf(dist[d]);
            })
            .collect(Collectors.joining(" ")); 

            System.out.println(res);
        }

        br.close();
    }
}