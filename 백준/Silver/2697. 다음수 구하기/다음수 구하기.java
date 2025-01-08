import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            List<Integer> list = Arrays.stream(br.readLine().split(""))
            .map(Integer::valueOf).collect(Collectors.toList());

            // 피벗 찾기
            int idx = list.size() - 2;
            while (idx >= 0 && list.get(idx + 1) <= list.get(idx)) {
                idx--;
            }
            if(idx < 0){
                System.out.println("BIGGEST");
                continue;
            }

            // 피벗 이후 오른쪽부터 피벗보다 큰 수 찾기
            int j = list.size() - 1;

            while (j > idx && list.get(idx) >= list.get(j)) {
                j--;
            }

            // 스왑
            int a = list.get(idx);
            list.set(idx, list.get(j));
            list.set(j, a);

            // 이후 리스트 오름차순 정렬
            List<Integer> remain = list.subList(0, idx + 1);
            List<Integer> sub = list.subList(idx + 1, list.size());
            sub.sort(Comparator.naturalOrder());
            remain.addAll(sub);

            // 출력
            String ret = remain.stream().map(String::valueOf)
            .collect(Collectors.joining());

            System.out.println(ret);
        }

    }
}
