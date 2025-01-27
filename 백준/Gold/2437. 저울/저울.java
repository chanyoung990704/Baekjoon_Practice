import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        list.sort(Comparator.naturalOrder());

        int target = 1;

        for(int i = 0 ; i < list.size() ; i++) {
            int cur = list.get(i);
            if(cur > target){
                break;
            }
            target += cur;
        }

        System.out.println(target);
    }
}
