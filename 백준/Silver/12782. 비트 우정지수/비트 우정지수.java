import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        while(T > 0) {
            String[] parsed = br.readLine().split(" ");
            String a = parsed[0];
            String b = parsed[1];

            int cnt = 0;
            int zeroOne = 0;
            int oneZero = 0;

            for(int i = 0 ; i < a.length() ; i++){
                if(a.charAt(i) == '0' && b.charAt(i) == '1') zeroOne++;
                if(a.charAt(i) == '1' && b.charAt(i) == '0') oneZero++;
            }

            cnt = Math.max(zeroOne, oneZero);

            System.out.println(cnt);
            T--;
        }

        br.close();
    }
}
