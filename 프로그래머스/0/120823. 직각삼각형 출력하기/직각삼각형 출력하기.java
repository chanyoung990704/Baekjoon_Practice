import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        IntStream.range(1, n + 1)
            .forEach(i -> {
                int idx = 0;
                while(idx < i) {
                    System.out.print("*");
                    idx++;
                }
                System.out.println("");
            });
        
    }
}