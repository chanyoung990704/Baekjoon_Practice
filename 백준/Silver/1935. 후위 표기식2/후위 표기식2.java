import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        String input = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put((char)('A' + i), Integer.valueOf(br.readLine()));
        }

        Deque<Double> dq = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if('A' <= c && c <= 'Z') {
                dq.addLast(Double.valueOf(map.get(c)));
            }else{
                if(dq.size() < 2){
                    break;
                }
                double a = dq.pollLast();
                double b = dq.pollLast();
                if (c == '+') {
                    dq.addLast(a+b);
                }else if(c == '-'){
                    dq.addLast(b - a);
                } else if (c == '*') {
                    dq.addLast(a*b);
                }else if(c == '/'){
                    dq.addLast(b/a);
                }
            }
        }

        System.out.printf("%.2f", dq.pollLast());
    }
}
