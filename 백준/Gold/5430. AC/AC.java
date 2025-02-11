import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int T = Integer.valueOf(br.readLine());
        while (T -- > 0) {
            String func = br.readLine();
            int len = Integer.valueOf(br.readLine());
            String arr = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();
            if(len > 0){
                dq = new ArrayDeque<>(Arrays.stream(arr.substring(1, arr.length() - 1).split(","))
                .map(Integer::valueOf).collect(Collectors.toList()));
            }

            boolean err = false;
            boolean reverse = false;
            // 함수 실행
            for(char c : func.toCharArray()){
                if(c == 'R'){
                    reverse = !reverse;
                }else if(c == 'D'){
                    // 에러
                    if(dq.isEmpty()){
                        err = true;
                        break;
                    }else{
                        if(reverse){
                            dq.pollLast();
                        }else{
                            dq.pollFirst();
                        }
                    }
                }
            }

            if(err){
                System.out.println("error");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if(reverse){
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        sb.append(",");
                    }
                }
                else{
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        sb.append(",");
                    }
                }
                if(sb.charAt(sb.length() - 1) == ','){
                    sb.setLength(sb.length() - 1);
                }
                sb.append("]");
                System.out.println(sb.toString());
            }

        }

    }
}


