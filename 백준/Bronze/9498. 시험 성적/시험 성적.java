import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        
        if(N >= 90) System.out.println("A");
        else if(N >= 80) System.out.println("B");
        else if(N >= 70) System.out.println("C");
        else if(N >= 60) System.out.println("D");
        else System.out.println("F");
    }
}
