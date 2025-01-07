import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // 기본 유효성 검사
        if(str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        List<StringBuilder> list = new ArrayList<>();
        int cnt = 0;
        int max = 0;

        for(char c : str.toCharArray()) {
            if(c == 'q') {
                cnt++;
                max = Math.max(cnt, max);
                list.add(new StringBuilder("q"));
            } else {
                int idx = needChar(list, c);
                if(idx == -1) {
                    System.out.println(-1);
                    return;
                }

                list.set(idx, list.get(idx).append(c));
                if(list.get(idx).toString().equals("quack")) {
                    list.remove(idx);
                    cnt--;
                }
            }
        }

        // 마지막 상태 체크
        if(!list.isEmpty() || max == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(max);
    }

    static int needChar(List<StringBuilder> l, char c) {
        for(int i = 0; i < l.size(); i++) {
            String cur = l.get(i).toString();
            if(cur.equals("q") && c == 'u') return i;
            if(cur.equals("qu") && c == 'a') return i;
            if(cur.equals("qua") && c == 'c') return i;
            if(cur.equals("quac") && c == 'k') return i;
        }
        return -1;
    }
}
