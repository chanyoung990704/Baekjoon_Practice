import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        for(int l : list) map.put(l, map.getOrDefault(l, 0) + 1);

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Comparator.reverseOrder());

        System.out.println(values.get(0));

    }
}
