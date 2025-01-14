import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;
            String[] input = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            for(char c : input[1].toCharArray()){
                for(int i = 0 ; i < Integer.valueOf(input[0]) ; i++){
                    sb.append(c);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
