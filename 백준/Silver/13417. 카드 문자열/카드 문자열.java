import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            
            int N = Integer.valueOf(br.readLine());
            String[] parsed = br.readLine().split(" ");
            char left = parsed[0].charAt(0);
            String result = "" + left;

            for(int i = 1 ; i < parsed.length ; i++){
                char cur = parsed[i].charAt(0);
                if(cur <= left){
                    left = cur;
                    result = cur + result;
                }else{
                    result = result + cur;
                }
            }

            System.out.println(result);
            
            T--;
        }


        br.close();

    }
}
