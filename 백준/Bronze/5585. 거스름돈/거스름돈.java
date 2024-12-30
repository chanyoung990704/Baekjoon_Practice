import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cost = 1000 - Integer.valueOf(br.readLine());
        int[] money = new int[]{500, 100, 50, 10, 5, 1};
        int cnt = 0;

        for(int i = 0 ; i < money.length ; i++){
            cnt += (cost / money[i]);
            cost %= money[i]; 
        }

        System.out.println(cnt);
        br.close();
    }

}