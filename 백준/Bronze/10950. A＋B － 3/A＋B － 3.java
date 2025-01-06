import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < n ; i++){
            System.out.println(Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf).sum());
        }

    }
}
