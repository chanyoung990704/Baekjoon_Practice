import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            List<Integer> JN = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            int J = JN.get(0);
            int N = JN.get(1);

            List<Integer> box = new ArrayList<>();
            for(int i = 0 ; i < N ; i++){
                String[] curBox = br.readLine().split(" ");
                box.add(Integer.valueOf(curBox[0]) * Integer.valueOf(curBox[1]));
            }

            box.sort(Comparator.reverseOrder());

            int total = 0;
            int cnt = 0;
            while (total < J) {
                total += box.get(cnt);
                cnt++;
            }

            System.out.println(cnt);

        }

    }
}