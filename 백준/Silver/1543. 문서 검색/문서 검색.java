import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String p = br.readLine();

        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(str);

        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
