import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NL = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NL.get(0);
        int L = NL.get(1);


        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        list.sort(Comparator.comparing((List<Integer> cur) -> cur.get(0)));

        int prev = 0;
        int cnt = 0;
        while (!list.isEmpty()) {
            List<Integer> cur = list.get(0);

            // 새로 기준점 만들어야 하는 경우
            if(cur.get(0) > prev){
                prev = cur.get(0);
            }

            // 널빤지 최대한 깔기
            while (prev < cur.get(1)) {
                prev += L;
                cnt++;
            }

            list.remove(0);
        }

        System.out.println(cnt);
    }
}
