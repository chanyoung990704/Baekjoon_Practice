import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String line;

        while ((line = br.readLine()) != null) {
            int  low, upper, num, blank;
            low = upper = num = blank = 0;

            for (char c : line.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    upper++;
                }
                if (Character.isLowerCase(c)) {
                    low++;
                }
                if (Character.isDigit(c)) {
                    num++;
                }
                if (c == ' ') {
                    blank++;
                }
            }
            sb.append(low).append(" ").append(upper).append(" ").append(num).append(" ").append(blank).append("\n");
        }

        System.out.println(sb);
    }
}
