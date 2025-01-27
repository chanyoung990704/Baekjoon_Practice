import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int n = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            int c = Integer.valueOf(br.readLine());
            if(c == 0){
                if(pq.isEmpty()){
                    sb.append(0 + "\n");
                }else{
                    sb.append(pq.poll() + "\n");
                }
            }
            else{
                pq.offer(c);
            }
        }


        System.out.println(sb.toString());

    }
}
