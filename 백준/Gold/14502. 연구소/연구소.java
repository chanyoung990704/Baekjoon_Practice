import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{1, -1, 0, 0};
    static int val = Integer.MIN_VALUE;
    static List<List<Integer>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" "))
                         .mapToInt(Integer::valueOf)
                         .toArray();

        map = new ArrayList<>();
        for (int i = 0; i < NM[0]; i++) {
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
                                      .map(Integer::valueOf)
                                      .collect(Collectors.toList());
            map.add(cur);
        }

        List<List<Integer>> blank = new ArrayList<>();
        for (int i = 0; i < NM[0]; i++)
            for (int j = 0; j < NM[1]; j++)
                if (map.get(i).get(j) == 0) blank.add(List.of(i, j));

        getCombination(0, blank, new ArrayList<>());
        System.out.println(val);

        br.close();
    }

    static void getCombination(int idx, List<List<Integer>> blank, List<List<Integer>> result) {
        if (result.size() == 3) {
            val = Math.max(val, getBFS(result));
            return;
        }
        for (int i = idx; i < blank.size(); i++) {
            result.add(blank.get(i));
            getCombination(i + 1, blank, result);
            result.remove(result.size() - 1);
        }
    }

    static int getBFS(List<List<Integer>> result) {
        List<List<Integer>> curMap = new ArrayList<>();
        for (List<Integer> row : map) {
            curMap.add(new ArrayList<>(row));
        }
        for (List<Integer> re : result) curMap.get(re.get(0)).set(re.get(1), 1);
    
        boolean[][] visited = new boolean[curMap.size()][curMap.get(0).size()];
    
        for (int i = 0; i < curMap.size(); i++)
            for (int j = 0; j < curMap.get(0).size(); j++) {
                if (!visited[i][j] && curMap.get(i).get(j) == 2) {
                    Deque<List<Integer>> dq = new ArrayDeque<>();
                    dq.offer(List.of(i, j));
                    visited[i][j] = true;
    
                    while (!dq.isEmpty()) {
                        List<Integer> cur = dq.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int ny = cur.get(0) + dy[k];
                            int nx = cur.get(1) + dx[k];
                            if (isBoundary(ny, nx) && !visited[ny][nx] && curMap.get(ny).get(nx) == 0) {
                                visited[ny][nx] = true;
                                curMap.get(ny).set(nx, 2);  // 바이러스 확산
                                dq.offer(List.of(ny, nx));
                            }
                        }
                    }
                }
            }
    
        int cnt = 0;
        for (int i = 0; i < curMap.size(); i++)
            for (int j = 0; j < curMap.get(0).size(); j++)
                if (curMap.get(i).get(j) == 0) cnt++;
    
        return cnt;
    }

    static boolean isBoundary(int y, int x) {
        return y >= 0 && y < map.size() && x >= 0 && x < map.get(0).size();
    }
}