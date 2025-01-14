import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(input.startsWith(" ")){
            input = input.substring(1, input.length());
        }
        if(input.endsWith(" ")){
            input = input.substring(0, input.length() - 1);
        }

        if(input.length() == 0){
            System.out.println(0);
            return;
        }

        System.out.println(input.split(" ").length);

    }
}
