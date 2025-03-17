

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length(); i++) {
            char cur = str.charAt(i);

            // 알파벳 대문자
            if (Character.isAlphabetic(cur)) {
                sb.append(cur);
                continue;
            }

            // 괄호
            if(cur == '('){
                dq.offerLast(cur);
            } else if (cur == ')') {
                // 여는 괄호 나올 때까지
                while (!dq.isEmpty() && dq.peekLast() != '(') {
                    sb.append(dq.pollLast());
                }
                if(!dq.isEmpty() && dq.peekLast() == '(') {
                    dq.pollLast();
                }
            }
            else{
                // 연산자
                int p = getOperationPriority(cur);
                while (!dq.isEmpty() && getOperationPriority(dq.peekLast()) >= p) {
                    sb.append(dq.pollLast());
                }
                dq.offerLast(cur);
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        System.out.println(sb.toString());

    }

    static int getOperationPriority(char c) {
        switch (c) {
            case '+':
                case '-':
                    return 1;
                    case '*':
                        case '/':
                            return 2;
                            default:
                                return 0;
        }
    }
}
