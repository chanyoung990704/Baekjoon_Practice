import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String num = String.valueOf(br.readLine());

        int ret = (int)Arrays.stream(num.split(""))
        .mapToInt(Integer::valueOf)
        .reduce((a, b) -> a + b)
        .orElse(-1);

        System.out.println(ret);

    }
}
