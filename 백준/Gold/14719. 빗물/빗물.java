import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int[] HW = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int H = HW[0];
        int W = HW[1];

        int[] wArr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        if(W < 3){
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Integer> right = new ArrayDeque<>();

        left.offer(wArr[0]);
        for(int i = 2 ; i < wArr.length ; i++){
            right.offerLast(wArr[i]);
        }

        int total = 0;

        for(int i = 1 ; i < wArr.length - 1 ; i++){
            int maxLeft = left.peek();
            int maxRight = Collections.max(right);

            if(maxLeft == 0 || maxRight == 0){
                
            }else{
                int water = Math.min(maxLeft, maxRight) - wArr[i];
                if(water > 0){
                    total += water;
                }
            }

            left.offer(wArr[i]);
            right.pollFirst();
        }
        
        System.out.println(total);
    }
}



