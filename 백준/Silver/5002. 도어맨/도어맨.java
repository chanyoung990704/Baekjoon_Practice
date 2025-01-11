import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<String> list = Arrays.stream(br.readLine().split(""))
        .collect(Collectors.toList());


        int diff = 0;
        int cnt = 0;

        while (!list.isEmpty()) {
            // 첫번째
            String first = list.get(0);
            int diffFirst = ((first.equals("M")) ? 1 : -1) + diff;

            Integer diffSecond = null;
            if(list.size() > 1){
                String second = list.get(1);
                diffSecond = ((second.equals("M")) ? 1 : -1) + diff;
            }

            // 첫번째 입장 확인
            if(Math.abs(diffFirst) <= N && (diffSecond == null || 
            Math.abs(diffFirst) <= Math.abs(diffSecond))){
                diff = diffFirst;
                list.remove(0);
            }else if(diffSecond != null && Math.abs(diffSecond) <= N){
                diff = diffSecond;
                list.remove(1);
            }else{
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
