import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int N = Integer.valueOf(br.readLine());
            List<Long> list = Arrays.stream(br.readLine().split(" "))
            .map(Long::valueOf).collect(Collectors.toList());

            long price = 0;
            long totalPrice = 0;

            for(int i = list.size() - 1 ; i >= 0 ; i--){
                if(list.get(i) > price) price = list.get(i);
                else if(list.get(i) < price) totalPrice += Math.abs(list.get(i) - price);
            }

            System.out.println(totalPrice);
        }
    }
}