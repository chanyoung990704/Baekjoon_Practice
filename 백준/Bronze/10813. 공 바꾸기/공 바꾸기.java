import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> list = IntStream.range(1, N + 1)
        .mapToObj(Integer::valueOf).collect(Collectors.toList());

        for(int i = 0 ; i < M ; i++){
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            swap(list, cur.get(0) - 1, cur.get(1) - 1);
        }

        System.out.println(list.stream()
        .map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
    }

    static void swap(List<Integer> list, int i, int j){
        int v = list.get(i);
        list.set(i, list.get(j));
        list.set(j, v);
    }
}
