import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int max = 1000000000;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        while (list.get(list.size() - 1) + list.get(list.size() - 2) <= max) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }

        for(int i = 0 ; i < N ; i++){
            int t = Integer.valueOf(br.readLine());

            List<Integer> res = new ArrayList<>();
            while (t > 0) {
                // 최대 근접 값 찾기
                int lo = 0;
                int hi = list.size() - 1;
                int r = 0;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int midVal = list.get(mid);

                    if(midVal > t){
                        hi = mid - 1;
                    }else{
                        r = mid;
                        lo = mid + 1;
                    }
                }

                res.add(list.get(r));
                t -= list.get(r);
            }

            String result = res.stream()
            .sorted()
            .map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
        }
    } 
}
