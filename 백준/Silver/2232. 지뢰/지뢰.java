import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) list.add(Integer.valueOf(br.readLine()));

        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; ){
            
            // 증가
            while (i + 1 < list.size() && list.get(i) < list.get(i + 1)) {
                i++;
            }
            res.add(i + 1);
            //감소
            while (i + 1 < list.size() && list.get(i) > list.get(i + 1)) {
                i++;
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(int r : res) sb.append(r + "\n");

        System.out.println(sb.toString());

    }
}
