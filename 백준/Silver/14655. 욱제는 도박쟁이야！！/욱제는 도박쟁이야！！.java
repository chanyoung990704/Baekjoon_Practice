import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> f = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> s = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int sum = f.stream().map(i -> Math.abs(i))
        .reduce(0, (a, b) -> a + b).intValue();

        System.out.println(sum * 2);
    }
}
