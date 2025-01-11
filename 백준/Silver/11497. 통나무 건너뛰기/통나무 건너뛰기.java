import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int N = Integer.valueOf(br.readLine());
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).sorted().collect(Collectors.toList());

            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();

            for(int i = 0 ; i < list.size() ; i++){
                if(i % 2 ==0){
                    firstList.add(list.get(i));
                }else{
                    secondList.add(0, list.get(i));
                }
            }

            firstList.addAll(secondList);

            int max = Math.abs(firstList.get(0) - firstList.get(firstList.size() - 1));
            for(int i = 0 ; i < firstList.size() - 1; i++){
                int cur = Math.abs(firstList.get(i) - firstList.get(i + 1));
                if(max < cur) max = cur;
            }

            System.out.println(max);
            
        }
    }
}
