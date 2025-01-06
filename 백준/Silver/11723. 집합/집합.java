import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력을 모으기 위한 StringBuilder

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>(); // 숫자 1~20을 관리하는 HashSet

        for (int i = 0; i < N; i++) {
            String[] op = br.readLine().split(" "); // 명령어와 숫자 분리
            String command = op[0];

            if (command.equals("add")) {
                int num = Integer.parseInt(op[1]);
                set.add(num); // 숫자 추가

            } else if (command.equals("remove")) {
                int num = Integer.parseInt(op[1]);
                set.remove(num); // 숫자 제거 (존재 여부 검사 불필요)

            } else if (command.equals("check")) {
                int num = Integer.parseInt(op[1]);
                // 포함 여부를 StringBuilder에 추가
                sb.append(set.contains(num) ? "1\n" : "0\n");

            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(op[1]);
                // 포함 여부에 따라 추가/제거
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }

            } else if (command.equals("all")) {
                // 1~20 채우기
                for (int num = 1; num <= 20; num++) {
                    set.add(num);
                }

            } else if (command.equals("empty")) {
                // 모든 숫자 제거
                set.clear();
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}
