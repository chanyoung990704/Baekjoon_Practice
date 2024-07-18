import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        System.out.println(s[0] - s[1]);

        br.close();
    }

}
