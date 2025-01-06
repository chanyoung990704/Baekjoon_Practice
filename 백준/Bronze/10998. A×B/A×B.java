import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).reduce(1, (a,b) -> a * b));
    }
}
