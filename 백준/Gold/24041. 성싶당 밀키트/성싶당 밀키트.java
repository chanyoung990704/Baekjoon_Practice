import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NGK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NGK.get(0);
        int G = NGK.get(1);
        int K = NGK.get(2);

        List<List<Integer>> ingredients = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            ingredients.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        long lo = 1;  // int를 long으로 변경
        long hi = 2_000_000_000;  // 상한값 증가
        long ret = 0;  // int를 long으로 변경

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;  // int를 long으로 변경
            long val = getVal(ingredients, mid, K);  // int를 long으로 변경

            if(val > G){
                hi = mid - 1;
            }else{
                ret = mid;
                lo = mid + 1;
            }
        }

        System.out.println(ret);
    }

    static long getVal(List<List<Integer>> ingredients, long mid, int K){  // 반환형과 매개변수 타입 변경
        // 중요하지 않은 음식들 리스트
        List<Long> nonVal = ingredients.stream()  // Integer를 Long으로 변경
        .filter(i -> i.get(2) == 1)
        .map(i -> (long)i.get(0) * Math.max(1, mid - i.get(1)))  // long 형변환 추가
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

        // 전체 세균 합
        long sum = ingredients.stream()  // int를 long으로 변경
        .mapToLong(i -> (long)i.get(0) * Math.max(1, mid - i.get(1))).sum();  // mapToInt를 mapToLong으로 변경

        // 중요하지 않은 세균 제거
        int cnt = 0;
        while (cnt < nonVal.size() && cnt < K) {
            sum -= nonVal.get(cnt);
            cnt++;
        }

        return sum;
    }
}
