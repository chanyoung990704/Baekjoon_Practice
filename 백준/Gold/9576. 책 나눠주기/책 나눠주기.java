import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            List<Integer> NM = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            int N = NM.get(0);
            int M = NM.get(1);

            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0 ; i < M ; i++){
                list.add(
                    Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
                );
            }

            list.sort(Comparator.comparing((List<Integer> l) -> l.get(1)));

            boolean[] visited = new boolean[N + 1];
            int cnt = 0;
            for(int i = 0 ; i < list.size() ; i++){
                List<Integer> cur = list.get(i);
                for(int j = cur.get(0) ; j <= cur.get(1) ; j++){
                    if(!visited[j]){
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}

