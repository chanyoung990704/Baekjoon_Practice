import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> path = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> price = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());      

        int prev = price.get(0);
        int dist = 0;
        long total = 0;
        for(int i = 0 ; i < N ; i++){
            if(i == N - 1){
                total += prev * dist;
                break;
            }
            if(price.get(i) < prev){
                total += prev * dist;
                dist = 0;
                prev = price.get(i);
            }
            dist += path.get(i);
        }

        System.out.println(total);

    }
}
