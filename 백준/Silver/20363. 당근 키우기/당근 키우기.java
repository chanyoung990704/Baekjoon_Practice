import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> XY = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int X = XY.get(0);
        int Y = XY.get(1);

        int min = Math.min(X, Y);

        System.out.println(X + Y + (min / 10));

        br.close();
    }
}
