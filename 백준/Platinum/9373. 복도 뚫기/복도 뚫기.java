import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{

    static int[] parent;

    static int findParent(int n){
        if(parent[n] != n){
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    static class Dist{
        double dist;
        int from;
        int to;

        public Dist(double dist, int from, int to){
            this.dist = dist;
            this.from = from;
            this.to = to;
        }
    }

    static class Circle{
        int x;
        int y;
        int r;
        public Circle(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =  Integer.parseInt(br.readLine());

        while(T-->0){
            int w =  Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // 센서 없을 때 - 수정된 부분
            if (n == 0){
                System.out.printf("%.6f\n", w/2.0);  // 줄바꿈 추가, double 나눗셈 보장
                continue;
            }

            parent = new int[n + 2]; // 왼쪽 벽 n, 오른쪽 벽 n+1
            for(int i = 0 ; i<n+2 ; i++){
                parent[i] = i;
            }

            List<Circle> circles = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] xyr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                circles.add(new Circle(xyr[0], xyr[1], xyr[2]));
            }

            PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparing(i -> i.dist, Comparator.naturalOrder()));

            for(int i = 0 ; i < circles.size(); i++){
                // 왼쪽 벽
                double left = circles.get(i).x - circles.get(i).r;
                if(left <= 0){
                    unionParent(i, n);
                    pq.offer(new Dist(0, i, n));
                }else{
                    pq.offer(new Dist(left, i, n));
                }

                // 오른쪽 벽
                double right = w - (circles.get(i).r + circles.get(i).x);
                if(right <= 0){
                    unionParent(i, n+1);
                    pq.offer(new Dist(0, i, n+1));
                }else{
                    pq.offer(new Dist(right, i, n+1));
                }

                // 각각의 원
                for(int j = i + 1 ; j < circles.size(); j++){
                    double circleToCircle = Math.sqrt(Math.pow(circles.get(i).x - circles.get(j).x, 2) + Math.pow(circles.get(i).y - circles.get(j).y, 2)) - circles.get(i).r - circles.get(j).r;
                    if(circleToCircle <= 0){
                        unionParent(i, j);
                        pq.offer(new Dist(0, i, j));
                    }
                    else{
                        pq.offer(new Dist(circleToCircle, i, j));
                    }
                }
            }

            double ans = 0;

            // 크루스칼 알고리즘
            while (!pq.isEmpty()){
                Dist d = pq.poll();
                // 연결
                if(findParent(d.from) != findParent(d.to)){
                    unionParent(d.from, d.to);
                    if(findParent(n+1) == findParent(n)){
                        ans = d.dist;
                        break;
                    }
                }
            }

            // 출력 형식 통일 - 수정된 부분
            System.out.printf("%.6f\n", ans/2.0);
        }
    }
}