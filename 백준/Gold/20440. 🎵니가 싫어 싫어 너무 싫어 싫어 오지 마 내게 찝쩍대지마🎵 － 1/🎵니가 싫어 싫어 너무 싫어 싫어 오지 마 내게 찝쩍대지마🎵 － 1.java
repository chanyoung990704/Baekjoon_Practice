import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 구간 입력받고, 이벤트 기록
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int output = Integer.parseInt(st.nextToken());

            treeMap.merge(input, 1, Integer::sum);
            treeMap.merge(output, -1, Integer::sum);
        }

        // 구간 길이
        int[] section = new int[]{0, 0};
        int len = 0;
        int ret = 0;
        boolean record = false;

        // 길이 탐색
        for (Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
            // 길이 계산
            len += e.getValue();

            // 리턴값 갱신
            if (len > ret) {
                ret = len;
                section[0] = e.getKey();
                record = true;
            }

            // 처음으로 줄어들 때
            if (ret > len && record) {
                section[1] = e.getKey();
                record = false;
            }
        }

        sb.append(ret).append("\n").append(section[0] + " " + section[1]);
        System.out.println(sb);

    }
}
