import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int N = Integer.valueOf(br.readLine());
            int[] cnt = new int[5];

            // 60분 단위 계산
            int sixties = N / 60;
            int tens = (N % 60) / 10;
            int ones = N % 10;

            // 1의 자리가 5보다 크면 10의 자리 올림
            if (ones > 5) {
                tens += 1;
                ones -= 10;
            }
            // 10의 자리가 3보다 크면 60분 단위 올림
            if (tens > 3) {
                sixties += 1;
                tens -= 6;
            }
            // 특수 케이스 처리
            if (tens < 0 && ones == 5) {
                tens += 1;
                ones -= 10;
            }

            cnt[0] = sixties;
            cnt[2-(tens >= 0 ? 1 : 0)] = Math.abs(tens);
            cnt[4-(ones >= 0 ? 1 : 0)] = Math.abs(ones);

            String res = Arrays.stream(cnt).mapToObj(Integer::valueOf).map(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(res);
        }
    }
}
