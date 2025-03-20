
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.*;
import java.util.regex.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        while (t-- > 0) {
            String line = br.readLine();

            Deque<Character> stack = new ArrayDeque<>();
            Deque<Character> back = new ArrayDeque<>();

            for (char c : line.toCharArray()) {
                // < 인경우 back에 추가
                if (c == '<' && !stack.isEmpty()) {
                    back.offerLast(stack.pollLast());
                }
                // > 인경우 복원
                else if (c == '>' && !back.isEmpty()) {
                    stack.offerLast(back.pollLast());
                }
                // - 인경우 삭제
                else if (c == '-' && !stack.isEmpty()) {
                    stack.pollLast();
                } else if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                    stack.offerLast(c);
                }
            }

            while (!back.isEmpty()) {
                stack.offerLast(back.pollLast());
            }

            // 결과
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }
            System.out.println(sb.toString());
        }
    }
}
