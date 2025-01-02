import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> MK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int M = MK.get(0);
        int K = MK.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int total = list.stream().mapToInt(Integer::valueOf).sum();

        if(total < M * K) System.out.println("STRESS");
        else{
            list.sort(Comparator.reverseOrder());
            int cnt = 0;
            int person = 0;
            int need = M * K;
            for(int cur : list){
                cnt += cur;
                person++;
                if(cnt >= need) break;
            }
            System.out.println(person);
        }

        br.close();
    }
}
