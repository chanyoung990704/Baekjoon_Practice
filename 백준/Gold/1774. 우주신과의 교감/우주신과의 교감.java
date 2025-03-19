
import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int findParent(int n){
        if(parent[n] != n){
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }

    static void unionParent(int a, int b) {
        int ra = findParent(a);
        int rb = findParent(b);
        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        parent = new int[N + 1];
        for(int i=1; i<=N; i++) parent[i] = i;

        // 좌표 입력
        int[][] idxs = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            idxs[i][0] = xy[0];
            idxs[i][1] = xy[1];
        }

        // 이미 연결된 간선 처리 (pairs 배열 제거)
        for(int i=0; i<M; i++){
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            unionParent(ab[0], ab[1]);
        }

        // 가능한 모든 간선 생성
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        for (int i=1; i<N; i++) {
            for(int j=i+1; j<=N; j++){
                double dist = Math.sqrt(Math.pow(idxs[i][0]-idxs[j][0],2)+Math.pow(idxs[i][1]-idxs[j][1],2));
                pq.offer(new double[]{dist, i, j});
            }
        }

        // 크루스칼 알고리즘 적용
        double total = 0.0;
        while (!pq.isEmpty()){
            double[] cur = pq.poll();
            double dist = cur[0];
            int a = (int)cur[1], b=(int)cur[2];

            if(findParent(a)!=findParent(b)){
                total += dist;
                unionParent(a,b);
            }
        }

        System.out.printf("%.2f", total);
    }
}