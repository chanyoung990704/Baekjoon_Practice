import java.io.*;
import java.util.*;

public class Main {

    static class Problem {
        StringBuilder sb;
        int cnt;

        public Problem(StringBuilder sb, int cnt) {
            this.sb = sb;
            this.cnt = cnt;
        }

        public void swap(int i, int j) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK =  br.readLine().split(" ");

        StringBuilder N = new StringBuilder(NK[0]);
        int K = Integer.parseInt(NK[1]);

        Queue<Problem> q = new LinkedList<>();
        q.offer(new Problem(N, 0));

        // 방문 관리: 각 단계별로 visited 집합 사용
        Set<String>[] visited = new HashSet[K+1];
        for(int i=0; i<=K; i++) visited[i] = new HashSet<>();
        visited[0].add(N.toString());

        int ans = -1;

        while (!q.isEmpty()) {
            Problem p = q.poll();

            // K번 교체 완료 시 최대값 갱신
            if (p.cnt == K) {
                ans = Math.max(ans, Integer.valueOf(p.sb.toString()));
                continue;
            }

            // 교체하기
            for(int i = 0 ; i < p.sb.length() - 1 ; i++) {
                for(int j = i + 1 ; j < p.sb.length(); j++) {
                    p.swap(i, j);
                    // 0으로 시작하면
                    if (p.sb.charAt(0) == '0') {
                        p.swap(i, j);
                        continue;
                    }
                    // (cnt+1) 단계 방문 여부 확인
                    if(!visited[p.cnt+1].contains(p.sb.toString())) {
                        visited[p.cnt+1].add(p.sb.toString());
                        q.offer(new Problem(new StringBuilder(p.sb), p.cnt + 1));
                    }
                    // 원상복구
                    p.swap(i, j);
                }
            }
        }

        System.out.println(ans);
    }
}
