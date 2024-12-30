import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zero = 0;
        int one = 0;

        // 0 그룹 찾기
        Pattern p = Pattern.compile("0+");
        Matcher m = p.matcher(S);

        while (m.find()) {
            zero++;
        }

        // 1그룹 찾기
        p = Pattern.compile("1+");
        m = p.matcher(S);
        while (m.find()) {
            one++;
        }

        System.out.println(Math.min(zero, one));

        br.close();


    }
}