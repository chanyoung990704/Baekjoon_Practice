import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        // 양수 리스트
        List<Integer> positive = list.stream().filter(i -> i > 0)
        .sorted().collect(Collectors.toList());

        // 음수 리스트
        List<Integer> negative = list.stream().filter(i -> i < 0)
        .sorted().collect(Collectors.toList());

        // 양수, 음수 중 가장 멀리있는 것
        int posMax = (positive.isEmpty()) ? 0 : positive.get(positive.size() - 1);
        int negMax = (negative.isEmpty()) ? 0 : Math.abs(negative.get(0));
        
        int total = 0;

        // 양수 계산
        for(int i = positive.size() - 1 ; i >= 0 ;) {
            // 양수가 가장 멀리있는 경우
            if(i == positive.size() - 1 && posMax >= negMax){
                // 가장 마지막에 갖다 놓는다
                total += posMax;
                i -= M;
                continue;
            }
            // 왕복
            total += positive.get(i) * 2;
            i -= M;
        }

        // 음수 계산
        for(int i = 0 ; i < negative.size() ;){
            // 음수가 가장 멀리 있는 경우
            if(i == 0 && posMax < negMax){
                total += negMax;
                i += M;
                continue;
            }
            // 왕복
            total += Math.abs(negative.get(i)) * 2;
            i += M;
        }

        System.out.println(total);
    }
}
