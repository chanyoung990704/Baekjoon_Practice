
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        while (t-- > 0) {

            int n = Integer.valueOf(br.readLine());

            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            list.sort(Comparator.naturalOrder());

            int i = 0;
            for (; i < list.size() - 1; i++) {
                if (list.get(i + 1).startsWith(list.get(i))) {
                    System.out.println("NO");
                    break;
                }
            }

            if(i == list.size() - 1) {
                System.out.println("YES");
            }

        }
    }
}
