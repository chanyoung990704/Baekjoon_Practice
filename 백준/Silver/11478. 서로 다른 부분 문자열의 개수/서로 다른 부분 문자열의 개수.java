import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 1개부터 최대길이까지
        Set<String> set = new HashSet<>();
        for(int i = 1 ; i <= str.length() ; i++){
            int idx = 0;
            while (idx + i <= str.length()) {
                set.add(str.substring(idx, idx + i));
                idx++;
            }
        }

        System.out.println(set.size());
    }
}
