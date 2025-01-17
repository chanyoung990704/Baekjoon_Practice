import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int total = list.stream().mapToInt(Integer::valueOf).sum();

        // 3의 배수가 아니면 예외
        if (total % 3 != 0) {
            System.out.println("NO");
            return;
        }

        int cnt = 0; // 2의 개수 저장
        for(int num : list){
            cnt += (num / 2);
        }

        // 2의 개수 >= 전체 횟수
        if(cnt >= total / 3){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
