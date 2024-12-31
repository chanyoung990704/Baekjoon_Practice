import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        PriorityQueue<Integer> sixPack = new PriorityQueue<>();
        PriorityQueue<Integer> onePack = new PriorityQueue<>();

        int N = NM.get(0);
        int M = NM.get(1);

        for(int i = 0 ; i < M ; i++){
            List<Integer> input = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            sixPack.offer(input.get(0));
            onePack.offer(input.get(1));
        }

        int sPrice = sixPack.peek();
        int oPrice = onePack.peek();
        int total = 0;
        if(sPrice >= oPrice * 6) total = N * oPrice;
        else{
            int allSix = N % 6 == 0 ? N / 6 : N / 6 + 1;
            allSix = sPrice * allSix;

            int someSix = sPrice * (N / 6) + (oPrice * (N % 6));
            total = Math.min(allSix, someSix);
        }

        System.out.println(total);

        br.close();
    }
}