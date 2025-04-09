import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    static class Edge{
        int from;
        int to;
        int cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws Exception{
        // 테스트 케이스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int tc = Integer.valueOf(br.readLine());
        
        while(tc-- > 0){
            // NMW
            int[] NMW = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();
            
            int n = NMW[0];
            int m = NMW[1];
            int w = NMW[2];
            
            // 양방향 간선 입력
            List<Edge> list = new ArrayList<>();
            
            for(int i = 0 ; i < m ; i++){
                int[] ftc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();
                int f = ftc[0];
                int t = ftc[1];
                int c = ftc[2];
                
                list.add(new Edge(f,t,c));
                list.add(new Edge(t,f,c));
            }
            
            // 웜홀 입력
            for(int i = 0 ; i < w ; i++){
                int[] ftc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();
                int f = ftc[0];
                int t = ftc[1];
                int c = ftc[2];
                
                list.add(new Edge(f,t,-c));
            }
            
            // 벨만포드
            
            if(belmanfod(n, list)){
                // 음의 간선 존재
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
            
        }
    }
    
    static boolean belmanfod(int n, List<Edge> list){
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1000000000);
        
        for(int i = 0 ; i < n - 1; i++){
            for(Edge e : list){
                if(dist[e.to] > dist[e.from] + e.cost){
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }
        
        // 음의 간선 확인
        for(Edge e : list){
            if(dist[e.to] > dist[e.from] + e.cost){
                return true;
            }
        }
        
        return false;
    }
}