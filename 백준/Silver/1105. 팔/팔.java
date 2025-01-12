import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> LR = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());


        String L = String.valueOf(LR.get(0));
        String R = String.valueOf(LR.get(1));

        if(L.length() != R.length()){
            System.out.println(0);
            return;
        }

        int len = L.length();

        int cnt = 0;
        for(int i = 0 ; i < len ; i++){
            if(L.charAt(i) == R.charAt(i)) {
                if(L.charAt(i) == '8') {
                    cnt++;
                }
            } else {
                break;
            }
        }
        

        System.out.println(cnt);

    }
}
