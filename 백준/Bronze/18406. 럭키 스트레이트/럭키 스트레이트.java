import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> N = Arrays.stream(br.readLine().split(""))
        .map(i -> Integer.valueOf(i))
        .collect(Collectors.toList());

        int lo = 0;
        int hi = N.size() - 1;

        int left, right;
        left = right = 0;
        while(lo < hi){
            left += N.get(lo);
            right += N.get(hi);
            lo++;
            hi--;
        }

        String ret = (left == right) ? "LUCKY"
        : "READY"; 

        System.out.println(ret);
        
        br.close();
    }

}