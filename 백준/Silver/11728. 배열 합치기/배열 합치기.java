import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int[] NM = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        
        int[] A = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int[] B = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();


        List<Integer> nums = new ArrayList<>();
        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < A.length && bIdx < B.length) {
            if(A[aIdx] < B[bIdx]){
                nums.add(A[aIdx++]);
            }else{
                nums.add(B[bIdx++]);
            }
        }

        while (aIdx < A.length) {
            nums.add(A[aIdx++]);
        }

        while (bIdx < B.length) {
            nums.add(B[bIdx++]);
        }

        System.out.println(nums.stream().map(String::valueOf)
        .collect(Collectors.joining(" ")));
    }
}



