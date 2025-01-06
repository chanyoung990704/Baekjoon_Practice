import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NX = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).filter(i -> i < NX.get(1)).collect(Collectors.toList());

        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
