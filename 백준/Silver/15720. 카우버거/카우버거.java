import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> BCD = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> buger = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> side = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> juice = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
        int minLen = Math.min(buger.size(), Math.min(side.size(), juice.size()));
        int idx = 0;
        int onSale = 0;

        while (idx < minLen) {
            onSale += (buger.get(idx) + side.get(idx) + juice.get(idx)) * 9 / 10;
            idx++;
        }

        while (idx < buger.size()) {
            onSale += buger.get(idx);
            idx++;
        }

        idx = minLen;
        while (idx < side.size()) {
            onSale += side.get(idx);
            idx++;
        }
        idx = minLen;

        while (idx < juice.size()) {
            onSale += juice.get(idx);
            idx++;
        }

        int withoutSale = buger.stream().reduce(0, (a, b) -> a + b).intValue()
        + juice.stream().reduce(0, (a, b) -> a + b).intValue()
        + side.stream().reduce(0, (a, b) -> a + b).intValue();

        System.out.println(withoutSale);
        System.out.println(onSale);
        

    }
}