import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Double> AB = Arrays.stream(br.readLine().split(" "))
        .map(Double::valueOf).collect(Collectors.toList());

        System.out.println(AB.get(0) / AB.get(1));
    }
}
