import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> strInt = new TreeMap<>();
        TreeMap<Integer, String> intStr = new TreeMap<>();

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            strInt.put(str, i);
            intStr.put(i, str);
        }

        for (int i = 0; i < M; i++) {
            // 문자인 경우
            String str = br.readLine();
            if(strInt.containsKey(str)) {
                System.out.println(strInt.get(str));
            } else {
                System.out.println(intStr.get(Integer.parseInt(str)));
            }
        }

    }
}
