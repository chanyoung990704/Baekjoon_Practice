import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] indegree;
    static boolean[][] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            // init
            int n = Integer.parseInt(br.readLine());
            indegree = new int[n + 1];
            adj = new boolean[n + 1][n + 1];
            
            List<Integer> rank = Arrays.stream(br.readLine().split(" "))
                                       .map(Integer::valueOf)
                                       .collect(Collectors.toList());
            
            for(int i = 0 ; i < rank.size() - 1 ; i++)
                for(int j = i + 1 ; j < rank.size() ; j++){
                    int team1 = rank.get(i);
                    int team2 = rank.get(j);
                    indegree[team2]++;
                    adj[team1][team2] = true;
                }

            int change = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < change ; i++){
                String[] parts = br.readLine().split(" ");
                if (parts.length != 2) {
                    System.out.println("INVALID INPUT");
                    continue;
                }
                int idx0 = Integer.parseInt(parts[0]);
                int idx1 = Integer.parseInt(parts[1]);

                if(adj[idx0][idx1]){
                    adj[idx0][idx1] = false;
                    adj[idx1][idx0] = true;
                    indegree[idx1]--;
                    indegree[idx0]++;
                }else{
                    adj[idx1][idx0] = false;
                    adj[idx0][idx1] = true;
                    indegree[idx0]--;
                    indegree[idx1]++;
                }
            }

        
        // topology
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> finalRank = new ArrayList<>();
        for(int i = 1 ; i < n + 1 ; i++)
            if(indegree[i] == 0) {
                q.addFirst(i);
                finalRank.add(i);
                indegree[i] = -1;
            }

        if(q.isEmpty()){
            System.out.println("IMPOSSIBLE");
            continue;
        }
        if(q.size() > 1){
            System.out.println("?");
            continue;
        }
        
        boolean isAmbiguous = false;

        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            // disconnect
            for(int i = 1; i < n + 1 ; i++)
                if(adj[cur][i])
                    indegree[i]--;
            for(int i = 1 ; i < n + 1 ; i++)
                if(indegree[i] == 0){
                    q.addFirst(i);
                    indegree[i] = -1;
                    finalRank.add(i);
                }
            if(q.size() > 1) {
                isAmbiguous = true;
                break;
            }
        }

        if(isAmbiguous){
            System.out.println("?");
            continue;
        }

        if(finalRank.size() < n){
            System.out.println("IMPOSSIBLE");
            continue;
        }

        System.out.println(finalRank.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(" ")));

        }
        br.close();
    }
}