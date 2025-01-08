import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            if(list.get(0) == 0) break;

            List<Integer> sub = list.subList(1, list.size());
            sub.sort(Comparator.naturalOrder());

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            // 0이 아닌 수 배치
            int idx1 = 0;
            while (idx1 < sub.size() && sub.get(idx1) == 0) {
                idx1++;
            }
            sb1.append(sub.get(idx1));

            int idx2 = idx1 + 1;
            while (idx2 < sub.size() && sub.get(idx2) == 0) {
                idx2++;
            }
            sb2.append(sub.get(idx2));

            // 나머지 배치
            for(int i = 0 ; i < sub.size() ; i++){
                if(i == idx1 || i == idx2) continue;
                if(i % 2 == 0) sb1.append(sub.get(i));
                else sb2.append(sub.get(i));
            }

            Long total = Long.valueOf(sb1.toString()) + Long.valueOf(sb2.toString());

            System.out.println(total);

        }

    }
}
