import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        List<Integer> NT = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<List<Integer>> foods = new ArrayList<>();
        // 성장률 오름차순
        for(int i = 0 ; i < NT.get(0) ; i++){
            foods.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }
        foods.sort(Comparator.comparing((List<Integer> l) -> l.get(1)));

        long total = 0;

        int day = NT.get(1) - NT.get(0) + 1;
        for(int i = 0 ; i < foods.size() ; i++){
            long v = (long) foods.get(i).get(1) * (day - 1);
            total += (v + foods.get(i).get(0));
            day++;
        }

        System.out.println(total);

    }
}


