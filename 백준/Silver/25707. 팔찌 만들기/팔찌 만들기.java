import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int dir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());


        long total = Math.abs(list.get(0) - list.get(list.size() - 1));

        for(int i = 0 ; i < list.size() - 1; i++){
            total += Math.abs(list.get(i + 1) - list.get(i));
        }

        System.out.println(total);
    }    
}
