import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>(); // 시작, 끝
        for(int i = 0 ; i < T ; i++){
            list.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 종료 시간 기준 오름차순
        list.sort(Comparator.comparing((List<Integer> l) -> l.get(1))
        .thenComparing((List<Integer> l) -> l.get(0)));

        int endTime = -1;
        int cnt = 0;

        for(List<Integer> cur : list){
            // 시작시간이 이전 종료시각 이후면
            if(cur.get(0) >= endTime){
                endTime = cur.get(1);
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
