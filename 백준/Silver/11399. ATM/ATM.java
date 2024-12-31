import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        int sum = 0;
        int time = 0;

        for(int person : list){
            time += person;
            sum += time;
        }

        System.out.println(sum);
        
        br.close();


    }
}