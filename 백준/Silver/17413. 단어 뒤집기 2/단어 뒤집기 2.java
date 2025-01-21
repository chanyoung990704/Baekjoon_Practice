import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Pattern p = Pattern.compile("<[\\w\\s]+>|\\s+|\\w+");
        Matcher m = p.matcher(str);

        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            // 공백
            if(m.group().trim().length() == 0){
                sb.append(m.group());
            }

            // <>
            else if(m.group().startsWith("<")){
                sb.append(m.group());
            }

            else{
                sb.append(new StringBuilder(m.group()).reverse());
            }

        }

        System.out.println(sb.toString());

    }
}
