import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int total = 0;
        boolean isMinus = false;

        for(char c : input.toCharArray()){
            if(c == '+' || c == '-'){
                int val = Integer.valueOf(sb.toString());
                if(isMinus){
                    total -= val;
                }else{
                    total += val;
                }
                if(c == '-'){
                    isMinus = true;
                }
                sb.setLength(0);
            }else{
                sb.append(c);
            }
        }

        if(sb.length() > 0){
            int val = Integer.valueOf(sb.toString());
            if(isMinus){
                total -= val;
            }else{
                total += val;
            }
        }
        System.out.println(total);
    }
}

