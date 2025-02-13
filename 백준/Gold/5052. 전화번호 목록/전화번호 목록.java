import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int t = Integer.valueOf(br.readLine());
        while (t -- > 0) {
            int n = Integer.valueOf(br.readLine());
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i < n;  i++){
                list.add(br.readLine());
            }

            list.sort(Comparator.naturalOrder());
            boolean consist = false;

            for(int i = 0 ; i < n - 1;  i++){
                if(list.get(i + 1).startsWith(list.get(i))){
                    consist = true;
                    break;
                }
            }

            System.out.println(consist == true ? "NO" : "YES");
        }
    }
}


