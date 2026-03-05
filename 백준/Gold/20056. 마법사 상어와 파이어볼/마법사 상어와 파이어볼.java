import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        List<int[]> fireballs = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new int[]{r,c,m,s,d});
        }

        // 턴 진행
        while(K-- > 0){
            // 새 그리드 생성
            List<int[]>[][] grid = new List[N][N];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    grid[i][j] = new ArrayList<>();
                }
            }

            // 파이어볼 이동
            for(int[] fireball : fireballs){
                int m = fireball[2];
                int s = fireball[3];
                int ny = ((fireball[0] + dy[fireball[4]] * s) % N + N) % N;
                int nx = ((fireball[1] + dx[fireball[4]] * s) % N + N) % N;
                
                grid[ny][nx].add(fireball);
            }

            List<int[]> nextFireballs = new ArrayList<>();
            // 이동이 끝난 뒤 2개 이상 파이어 볼이 있는 칸
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(grid[i][j].size() >= 2){
                        List<int[]> cur = grid[i][j];
                        int totalM = cur.stream().mapToInt(c -> c[2]).sum();
                        int totalS = cur.stream().mapToInt(c -> c[3]).sum();
                        int cnt = cur.size();
                        // 4개로 분할 (파이어볼 방향이)
                        boolean isAll = true;
                        for(int[] c : cur){
                            if(cur.get(0)[4] % 2 != c[4] %2){
                                isAll = false;
                                break;
                            }
                        }
                        int start = isAll ? 0 : 1;
                        for(int k = 0 ; k < 4 ; k++){
                            int nextM = totalM / 5;
                            int nextS = totalS / cnt;
                            if(nextM <= 0){
                                continue;
                            }
                            nextFireballs.add(new int[]{i,j,nextM,nextS, start});
                            start+=2;
                        }
                    }
                    // 1개
                    else if(grid[i][j].size() >= 1){
                        grid[i][j].get(0)[0] = i;
                        grid[i][j].get(0)[1] = j;
                        nextFireballs.add(grid[i][j].get(0));
                    }
                }
            }

            fireballs = nextFireballs;
        }

        // 남아있는 질량
        System.out.println(fireballs.stream().mapToInt(i -> i[2]).sum());
    } 
}
