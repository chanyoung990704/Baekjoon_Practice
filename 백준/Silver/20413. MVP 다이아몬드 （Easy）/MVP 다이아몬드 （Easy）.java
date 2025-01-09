import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        String rating = br.readLine();

        int prev = 0;
        int total = 0;
        for(char c : rating.toCharArray()){
            int max = 0;
            switch (c) {
                case 'B':
                    max = list.get(0);
                    break;

                case 'S':
                    max = list.get(1);
                    break;

                case 'G':   
                    max = list.get(2);
                    break;

                case 'P':
                    max = list.get(3);
                    break;

                case 'D':
                    total += list.get(3);
                    break;
            
                default:
                    break;
            }
            if(c != 'D'){
                int cur = (max - 1) - (prev);
                prev = cur;
                total += cur;
            }
        }

        System.out.println(total);

    }
}
