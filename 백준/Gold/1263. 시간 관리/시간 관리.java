import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> timeTable = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            timeTable.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 종료시각 내림차순
        timeTable.sort(Comparator.comparing((List<Integer> l) -> l.get(1)).reversed());

        int time = Integer.MAX_VALUE;

        for(int i = 0 ; i < timeTable.size() ; i++){
            List<Integer> cur = timeTable.get(i);
            int c = cur.get(0);
            int end = cur.get(1);

            // 갱신이 필요한 경우
            if(end <= time){
                time = end - c;
            }else{
                time -= c;
            }

            // 현재 시각이 0 미만이면 예외
            if(time < 0){
                break;
            }
        }

        if(time < 0){
            System.out.println(-1);
        }else{
            System.out.println(time);
        }


    }
}
