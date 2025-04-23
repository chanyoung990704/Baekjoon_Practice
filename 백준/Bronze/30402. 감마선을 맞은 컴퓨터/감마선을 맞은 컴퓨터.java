import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int cnt = 15;

        while (cnt-- > 0) {
            Set<Character> set = Arrays.stream(br.readLine().split(" "))
                    .map(s -> s.charAt(0))
                    .collect(Collectors.toSet());

            for(char c : set) {
                if (c == 'w') {
                    System.out.println("chunbae");
                    return;
                }

                if (c == 'b') {
                    System.out.println("nabi");
                    return;
                }

                if (c == 'g') {
                    System.out.println("yeongcheol");
                    return;
                }
            }
        }
        
    }
}
