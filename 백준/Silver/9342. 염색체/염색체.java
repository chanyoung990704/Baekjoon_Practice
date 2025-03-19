
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.*;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String line = br.readLine();
            Matcher m = p.matcher(line);
            if(m.find()) {
                sb.append("Infected!\n");
            }else{
                sb.append("Good\n");
            }
        }

        System.out.println(sb.toString());
    }
}
