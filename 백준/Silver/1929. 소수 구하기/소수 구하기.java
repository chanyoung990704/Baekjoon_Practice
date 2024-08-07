import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] MN = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        boolean[] isPrime = new boolean[MN[1] + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2 ; i <= Math.sqrt(MN[1]) ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j <= MN[1] ; j += i) isPrime[j] = false;
            }
        }

        for(int i = MN[0] ; i <= MN[1] ; i++){
            if(isPrime[i]) System.out.println(i);
        }

        br.close();
    }
}