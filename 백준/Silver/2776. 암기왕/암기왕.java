import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int N = Integer.valueOf(br.readLine());
            List<Integer> noteFirst = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).sorted().collect(Collectors.toList());

            int M = Integer.valueOf(br.readLine());
            List<Integer> noteSecond = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
        

            StringBuilder sb = new StringBuilder();
            for(int cur : noteSecond){
                if(Collections.binarySearch(noteFirst, cur) >= 0){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }

            System.out.print(sb.toString());
        
        }
    }
}
