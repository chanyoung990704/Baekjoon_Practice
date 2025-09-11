import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mainStr = br.readLine();
        int ret = 0;

        for(int i = 0 ; i < mainStr.length(); i++){
            String str = mainStr.substring(i);

            // failure 만들기
            int[] failure = new int[str.length()];

            int begin = 1;
            int matched = 0;

            while (begin + matched < str.length()) {
                if (str.charAt(matched) == str.charAt(begin + matched)) {
                    matched++;
                    failure[begin + matched - 1] = matched;
                } else if (matched == 0) {
                    begin++;
                } else {
                    begin += matched - failure[matched - 1];
                    matched = failure[matched - 1];
                }
            }


            ret = Math.max(ret, Arrays.stream(failure)
                    .max().getAsInt());

        }

        System.out.println(ret);
    }
}

