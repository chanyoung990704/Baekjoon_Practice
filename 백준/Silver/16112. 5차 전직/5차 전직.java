import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nk = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nk.get(0);
        int k = nk.get(1);

        List<Long> init = Arrays.stream(br.readLine().split(" "))
        .map(Long::valueOf).collect(Collectors.toList());
        
        init.sort(Comparator.naturalOrder());

        long total = 0;
        
        for(int i = 0 ; i < init.size() ; i++){
            total += Math.min(k, i) * init.get(i);
        }

        System.out.println(total);


    }
}
