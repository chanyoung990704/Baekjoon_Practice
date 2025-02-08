import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int P = Integer.valueOf(br.readLine());
        while (P -- > 0) {
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            int tc = list.get(0);
            // 리스트
            List<Integer> l = new ArrayList<>();
            int total = 0;
            for(int i = 1 ; i < list.size() ; i++){
                int cur = list.get(i);
                if(l.isEmpty()){
                    l.add(cur);
                    continue;
                }

                // 이분 탐색
                int pos = Collections.binarySearch(l, cur);
                pos = -(pos + 1);

                total += (l.size() - pos);
                l.add(pos, cur);
            }

            System.out.println(tc + " " + total);
        }

    }
}


