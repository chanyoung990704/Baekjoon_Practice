
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

        String line = br.readLine();

        // 공백 제외
        Pattern p = Pattern.compile("<[\\w\\s]+>|\\w+|\\s+");
        Matcher m = p.matcher(line);

        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String cur = m.group();
            // 공백이면
            if(cur.startsWith(" ")){
                sb.append(cur);
            }
            // <이면
            else if(cur.startsWith("<")){
                sb.append(cur);
            }
            else{
                // 뒤집기
                StringBuilder tmp = new StringBuilder(cur);
                sb.append(tmp.reverse());
            }
        }

        System.out.println(sb.toString());
    }
}
