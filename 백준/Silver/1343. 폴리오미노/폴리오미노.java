import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        s = s.replaceAll("X{4}", "AAAA");
        s = s.replaceAll("X{2}", "BB");

        if(s.contains("X")) System.out.println(-1);
        else System.out.println(s);



        br.close();


    }
}