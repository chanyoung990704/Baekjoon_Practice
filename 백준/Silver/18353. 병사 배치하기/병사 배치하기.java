import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int n = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        Collections.reverse(list);

        // 이분탐색으로 LIS 구하기
        List<Integer> lis = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            int cur = list.get(i);

            int pos = Collections.binarySearch(lis, cur);
            if(pos < 0){
                pos = -(pos + 1);
            }

            if(pos == lis.size()){
                lis.add(cur);
            }else{
                lis.set(pos, cur);
            }
        }

        System.out.println(list.size() - lis.size());

    }
}
