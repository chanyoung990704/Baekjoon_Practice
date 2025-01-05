import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        List<Long> list = Arrays.stream(br.readLine().split(" "))
        .map(Long::valueOf).collect(Collectors.toList());

        if(n == 1){
            System.out.println(list.get(0));
            return;
        }

        for(int i = list.size() - 2 ; i >= 0 ; i--){
            Long prev = list.get(i + 1);
            Long cur = list.get(i);

            if(cur < prev){
                Long m = prev / cur;
                if(prev % cur != 0) m++;

                list.set(i, cur * m);
            }
        }

        System.out.println(list.get(0));

    }
}
