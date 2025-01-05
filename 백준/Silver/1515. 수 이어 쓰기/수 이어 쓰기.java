import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int ret = 0;

        for(int i = 1; i <= 30000 ; i++){
            sb.append(i);
            int j = 0;
            int k = 0;

            while (j < sb.length() && k < str.length()) {
                if(sb.charAt(j) == str.charAt(k)) k++;
                j++;
            }

            if(k == str.length()){
                ret = i;
                break;
            }

        }

        System.out.println(ret);

        br.close();

    }
}
