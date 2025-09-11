import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        while (n-- > 0) {
            String str =  br.readLine();

            int lo = 0;
            int hi = str.length() - 1;

            while (lo < hi) {
                if(Character.toLowerCase(str.charAt(lo)) != Character.toLowerCase(str.charAt(hi))) {
                    System.out.println("No");
                    break;
                }

                lo++;
                hi--;
            }

            if (lo >= hi) {
                System.out.println("Yes");
            }
        }
    }
}
