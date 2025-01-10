import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int dir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int[] cnt = new int[1000 + 1];
        for(int l : list) cnt[l]++;

        int total = 0;

        for(int i = 0 ; i < cnt.length ; i++)
            total += Math.min(2, cnt[i]);

        System.out.println(total);

    }    
}
