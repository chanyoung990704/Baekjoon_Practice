import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        Deque<Character> dq = new ArrayDeque<>();
        for(char c : input.toCharArray()) {
            // 연산자 아닐 경우
            if('A' <= c && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                dq.offer(c);
            } else if (c == ')') {
                while(!dq.isEmpty() && dq.peekLast() != '(') {
                    sb.append(dq.pollLast());
                }
                dq.pollLast();
            }else {
                while(!dq.isEmpty() && getPriority(c) <= getPriority(dq.peekLast())) {
                    sb.append(dq.pollLast());
                }
                dq.offer(c);
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        System.out.println(sb.toString());

    }

    static int getPriority(char c) {
        if(c == '+' || c == '-') return 1;
        if(c == '*' || c == '/') return 2;
        return 0;
    }
}
