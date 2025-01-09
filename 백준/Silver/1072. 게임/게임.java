import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        Long X = (long)list.get(0);
        Long Y = (long)list.get(1);

        if(X == Y){
            System.out.println(-1);
            return;
        }

        long lo = 1;
        long hi = X;
        long target = (Y * 100) / X;
        long ret = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cur = (Y + mid) * 100 / (X + mid);

            if(target < cur){
                ret = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(ret);
    }
}
