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

        int cost = 0;
        if(N < 3) cost = list.stream().mapToInt(Integer::valueOf).sum();
        else{
            for(int i = 0 ; i < list.size() ;){
                int last = Math.min(list.size(), i + 3);
                List<Integer> sub = list.subList(i, last);
                if(sub.size() == 3){
                    cost += sub.get(0) + sub.get(1);
                }else{
                    cost += sub.stream().mapToInt(Integer::valueOf).sum();
                }
                i = last;
            }
        }

        System.out.println(cost);

        br.close();
    }
}
