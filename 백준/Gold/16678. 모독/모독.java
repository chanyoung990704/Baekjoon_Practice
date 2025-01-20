import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());

        long cnt = 0;
        int target = 1;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) >= target){
                cnt += (list.get(i) - target);
                target++;
            }
        }

        System.out.println(cnt);
    }
}
