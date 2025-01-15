import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int K = Integer.valueOf(br.readLine());

        
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        List<Integer> dist = new ArrayList<>();
        // 차이 값 저장
        for(int i = 1 ; i < list.size() ; i++){
            dist.add(list.get(i) - list.get(i - 1));
        }

        int result = 0;
        dist.sort(Comparator.reverseOrder());

        for(int i = K - 1; i < dist.size() ; i++){
            result += dist.get(i);
        }

        System.out.println(result);
    }
}
