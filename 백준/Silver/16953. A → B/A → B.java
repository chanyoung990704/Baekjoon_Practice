import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> AB = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int A = AB.get(0);
        int B = AB.get(1);

        int cnt = 0;
        while (B >= A) {
            if(B == A) break;

            if(B % 10 == 1) B /= 10;
            else if(B % 2 == 0) B /= 2;
            else break;
            cnt++;
        }

        if(A != B) System.out.println(-1); 
        else System.out.println(cnt + 1);
    }
}