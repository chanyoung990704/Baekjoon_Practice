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

        timeTable.sort(Comparator.comparing((List<Integer> l) -> l.get(1)).reversed());

        int prevEnd = Integer.MAX_VALUE;

        for(int i = 0 ; i < timeTable.size() ; i++) {
            List<Integer> cur = timeTable.get(i);
            int end = cur.get(1);
            int cost = cur.get(0);

            if(prevEnd > end){
                prevEnd = end - cost;
            }else{
                prevEnd -= cost;
            }
        }


        System.out.println(prevEnd);
    }
}
