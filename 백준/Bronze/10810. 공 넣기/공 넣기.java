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

        int[] arr = new int[N + 1];

        for(int i = 0 ; i < M ; i++){
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            for(int j = cur.get(0) ; j <= cur.get(1) ; j++){
                arr[j] = cur.get(2);
            }    
        }

        System.out.println(IntStream.range(1, N + 1)
        .mapToObj(i -> String.valueOf(arr[i])).collect(Collectors.joining(" ")));
    }
}
