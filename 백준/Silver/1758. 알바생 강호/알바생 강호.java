import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) list.add(Integer.valueOf(br.readLine()));

        Collections.sort(list, Comparator.reverseOrder());

        long cost = 0;
        for(int i = 0 ; i < list.size() ; i++){
            cost += list.get(i) - i < 0 ? 0 : list.get(i) - i;
        }

        System.out.println(cost);

        br.close();
    }
}
