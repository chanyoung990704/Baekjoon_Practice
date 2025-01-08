import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int max = list.get(list.size() - 1);
        int maxPrice = 0;

        for(int i = list.size() - 2 ; i >= 0 ; i--){
            int cur = list.get(i);
            if(cur < max) maxPrice = Math.max(maxPrice, Math.abs(max - cur));
            else if(cur > max) max = cur;
        }

        System.out.println(maxPrice);
    }
}