import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("[^UCP]","");

        Pattern p = Pattern.compile("U.*C.*P.*C");
        Matcher m = p.matcher(str);

        if(m.find()) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");

        br.close();


    }
}