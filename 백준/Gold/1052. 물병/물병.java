import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        StringBuilder sb = new StringBuilder(Integer.toBinaryString(N));
        int cnt = getCnt(sb);
    
        while (cnt > K) {
            sb = new StringBuilder(Integer.toBinaryString(++N));
            cnt = getCnt(sb);
        }

        System.out.println(N - NK.get(0));
    }


    static int getCnt(StringBuilder sb){
        int cnt = 0;
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}
