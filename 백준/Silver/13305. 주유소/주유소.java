import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 도로 길이와 주유소 가격 입력
        List<Integer> path = Arrays.stream(br.readLine().split(" "))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        List<Integer> price = Arrays.stream(br.readLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        long total = 0; // 총 비용
        int minPrice = price.get(0); // 현재까지의 최소 주유소 가격

        for (int i = 0; i < N - 1; i++) {
            // 최소 가격으로 현재 구간의 비용 계산
            total += (long) minPrice * path.get(i);

            // 다음 도시의 주유소 가격이 더 저렴하면 갱신
            if (price.get(i + 1) < minPrice) {
                minPrice = price.get(i + 1);
            }
        }

        System.out.println(total);
    }
}
