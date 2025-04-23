import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        // 정보 입력
        List<String> data = new ArrayList<>();
        for(int i = 0; i < n; i++){
            data.add(br.readLine());
        }

        // 쿼리
        for (int i = 0; i < m; i++) {
            String pattern = br.readLine()
                    .replaceAll("-", "[a-z]+");

            String regex = "^" + pattern + "$";

            Pattern p = Pattern.compile(regex);

            int cnt = 0;
            for (String d : data) {
                Matcher matchered = p.matcher(d);
                if (matchered.matches()) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }


    }
}
