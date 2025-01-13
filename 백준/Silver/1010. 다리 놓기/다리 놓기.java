import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());

    while (T > 0) {
        T--;
        List<Integer> num = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

        int n = num.get(1); // 전체 개수
        int r = num.get(0); // 선택할 개수
        long result = 1;

        // nCr = n!/(r!(n-r)!) = (n * (n-1) * ... * (n-r+1)) / (r * (r-1) * ... * 1)
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }

        System.out.println(result);
    }
}
}
