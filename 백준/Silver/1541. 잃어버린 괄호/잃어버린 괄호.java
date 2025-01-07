import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] parsed = str.split("-");

        int sum = 0;

        for(int i = 0 ; i < parsed.length ; i++){
            int cur = 0;
            String[] parsedI = parsed[i].split("\\+");
            for(String s : parsedI) cur += Integer.valueOf(s);
            
            if(i == 0) sum += cur;
            else sum -= cur;
        }

        System.out.println(sum);
    }
}