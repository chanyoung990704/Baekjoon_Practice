import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Set<String> set = new TreeSet<>();
        for(int i = 0 ; i < str.length() ; i++){
            set.add(str.substring(i, str.length()));
        }

        for(String s : set){
            System.out.println(s);
        }
    }
}
