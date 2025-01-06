import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++) {
            String[] op = br.readLine().split(" ");
            String cur = op[0];

            if(cur.equals("push")){
                dq.offerLast(Integer.valueOf(op[1]));
            }else if(cur.equals("pop")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.pollLast());
            }else if(cur.equals("size")){
                System.out.println(dq.size());
            }else if(cur.equals("empty")){
                if(dq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(cur.equals("top")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.peekLast());
            }

        }


    }
}
