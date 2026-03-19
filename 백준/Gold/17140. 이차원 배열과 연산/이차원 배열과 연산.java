import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int r, c, k;
    static int[][] map = new int[3][3];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            map[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        int T = 100;
        while (T-- >= 0) {
            if (r < map.length && c < map[0].length && map[r][c] == k) {
                System.out.println(Math.abs(100 - T - 1));
                return;
            }

            int R = map.length;
            int C = map[0].length;

            if (R >= C) {
                int[][] cMap = new int[R][100];
                for (int i = 0; i < R; i++) {
                    Arrays.fill(cMap[i], 0);
                }

                int maxLen = 0;

                for (int i = 0; i < R; i++) {
                    List<int[]> lis = new ArrayList<>();
                    int[] cnt = new int[101];
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] != 0) {
                            cnt[map[i][j]]++;
                        }
                    }

                    for (int j = 0; j <= 100; j++) {
                        if (cnt[j] > 0) {
                            lis.add(new int[]{j, cnt[j]});
                        }
                    }

                    lis.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

                    int idx = 0;
                    for (int[] l : lis) {
                        int v = l[0], c = l[1];
                        if (idx + 2 > 100) {
                            break;
                        }
                        cMap[i][idx++] = v;
                        cMap[i][idx++] = c;
                    }
                    maxLen = Math.max(maxLen, idx);
                }

                for (int i = 0; i < cMap.length; i++) {
                    cMap[i] = Arrays.copyOf(cMap[i], Math.min(100, maxLen));
                }

                map = cMap;
            } else {
                int[][] cMap = new int[100][C];
                for (int i = 0; i < 100; i++) {
                    Arrays.fill(cMap[i], 0);
                }

                int maxLen = 0;

                for (int i = 0; i < C; i++) {
                    List<int[]> lis = new ArrayList<>();
                    int[] cnt = new int[101];
                    for (int j = 0; j < R; j++) {
                        if (map[j][i] != 0) {
                            cnt[map[j][i]]++;
                        }
                    }

                    for (int j = 0; j <= 100; j++) {
                        if (cnt[j] > 0) {
                            lis.add(new int[]{j, cnt[j]});
                        }
                    }

                    lis.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

                    int idx = 0;
                    for (int[] l : lis) {
                        int v = l[0], c = l[1];
                        if (idx + 2 > 100) {
                            break;
                        }
                        cMap[idx++][i] = v;
                        cMap[idx++][i] = c;
                    }
                    maxLen = Math.max(maxLen, idx);
                }

                map = new int[Math.min(maxLen, 100)][C];
                for (int i = 0; i < map.length; i++) {
                    map[i] = Arrays.copyOf(cMap[i], C);
                }
            }
        }

        System.out.println(-1);
    }
}
