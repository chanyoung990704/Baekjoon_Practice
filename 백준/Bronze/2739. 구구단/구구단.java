import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        for(int i = 1; i <= 9 ; i++){
            System.out.println(N + " * " + i + " = " + N*i);
        }

    }
}
